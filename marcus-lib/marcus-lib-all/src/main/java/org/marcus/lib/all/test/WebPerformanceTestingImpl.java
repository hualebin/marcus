package org.marcus.lib.all.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class WebPerformanceTestingImpl implements WebPerformanceTesting {

    @Override
    public ConcurrencyTestResult concurrencyTest(String url, String method, int concurrencyNum, int requestTotal) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(concurrencyNum, concurrencyNum, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        List<RequestTask> taskList = new ArrayList<>(requestTotal);
        for (int i = 0;i < requestTotal; i++) {
            taskList.add(new RequestTask(url, method));
        }

        long averageResponseTime = 0L;
        long ninetyFivePercentageResponseTime = 0L;
        long minPercentageResponseTime = 0L;
        long maxPercentageResponseTime = 0L;
        int requestSucceedNum = 0;
        int requestFailedNum = 0;

        try {
            List<Future<RequestTaskResult>> resultList = executor.invokeAll(taskList);

            if (resultList != null && !resultList.isEmpty()) {
                List<Long> responseTimeList = new ArrayList<>();
                for (Future<RequestTaskResult> future : resultList) {
                    RequestTaskResult result = future.get();
                    responseTimeList.add(result.getResponseTime());
                    if (result.getRequestSuccess()) {
                        requestSucceedNum++;
                    }
                }

                maxPercentageResponseTime = responseTimeList.stream().max(Long::compareTo).get();
                minPercentageResponseTime = responseTimeList.stream().min(Long::compareTo).get();
                averageResponseTime = responseTimeList.stream().reduce(Long::sum).get() / responseTimeList.size();//平均值

                Collections.sort(responseTimeList);
                int index = new Double(responseTimeList.size() * 0.95).intValue() - 1;
                index = (index >= 0) ? index : 0;
                ninetyFivePercentageResponseTime = responseTimeList.get(index);

                requestFailedNum = requestTotal - requestSucceedNum;

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ConcurrencyTestResult concurrencyTestResult = new ConcurrencyTestResult(
                averageResponseTime,
                ninetyFivePercentageResponseTime,
                minPercentageResponseTime,
                maxPercentageResponseTime,
                requestSucceedNum,
                requestFailedNum
        );

        return concurrencyTestResult;
    }

    public static void main(String[] args) {
        WebPerformanceTesting webPerformanceTesting = new WebPerformanceTestingImpl();

        String url = "https://www.baidu.com";
        String method = "GET";
        int concurrencyNum = 10;
        int requestTotal = 100;

        ConcurrencyTestResult concurrencyTestResult = webPerformanceTesting.concurrencyTest(url, method, concurrencyNum, requestTotal);

        System.out.printf("请求URL： %s\n", url);
        System.out.printf("请求方法： %s\n", method);
        System.out.printf("并发数： %s\n", concurrencyNum);
        System.out.printf("请求总数： %s\n", requestTotal);
        concurrencyTestResult.print();
    }

}

