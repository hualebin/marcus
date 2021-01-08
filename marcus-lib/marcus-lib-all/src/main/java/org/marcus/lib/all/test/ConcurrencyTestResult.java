package org.marcus.lib.all.test;

/**
 * 并发测试结果
 */
public class ConcurrencyTestResult {

    /**
     * 平均响应时间（毫秒）
     */
    private long averageResponseTime;

    /**
     * 95%响应时间（毫秒）
     */
    private long ninetyFivePercentageResponseTime;

    /**
     * 最小响应时间（毫秒）
     */
    private long minPercentageResponseTime;

    /**
     * 最大响应时间（毫秒）
     */
    private long maxPercentageResponseTime;

    /**
     * 请求成功次数
     */
    private int requestSucceedNum;

    /**
     * 请求失败次数
     */
    private int requestFailedNum;

    public ConcurrencyTestResult() {

    }

    public ConcurrencyTestResult(long averageResponseTime, long ninetyFivePercentageResponseTime, long minPercentageResponseTime, long maxPercentageResponseTime, int requestSucceedNum, int requestFailedNum) {
        this.averageResponseTime = averageResponseTime;
        this.ninetyFivePercentageResponseTime = ninetyFivePercentageResponseTime;
        this.minPercentageResponseTime = minPercentageResponseTime;
        this.maxPercentageResponseTime = maxPercentageResponseTime;
        this.requestSucceedNum = requestSucceedNum;
        this.requestFailedNum = requestFailedNum;
    }

    public long getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(long averageResponseTime) {
        this.averageResponseTime = averageResponseTime;
    }

    public long getNinetyFivePercentageResponseTime() {
        return ninetyFivePercentageResponseTime;
    }

    public void setNinetyFivePercentageResponseTime(long ninetyFivePercentageResponseTime) {
        this.ninetyFivePercentageResponseTime = ninetyFivePercentageResponseTime;
    }

    public long getMinPercentageResponseTime() {
        return minPercentageResponseTime;
    }

    public void setMinPercentageResponseTime(long minPercentageResponseTime) {
        this.minPercentageResponseTime = minPercentageResponseTime;
    }

    public long getMaxPercentageResponseTime() {
        return maxPercentageResponseTime;
    }

    public void setMaxPercentageResponseTime(long maxPercentageResponseTime) {
        this.maxPercentageResponseTime = maxPercentageResponseTime;
    }

    public int getRequestSucceedNum() {
        return requestSucceedNum;
    }

    public void setRequestSucceedNum(int requestSucceedNum) {
        this.requestSucceedNum = requestSucceedNum;
    }

    public int getRequestFailedNum() {
        return requestFailedNum;
    }

    public void setRequestFailedNum(int requestFailedNum) {
        this.requestFailedNum = requestFailedNum;
    }

    public void print() {
        System.out.printf("平均响应时间： %s(ms)\n", averageResponseTime);
        System.out.printf("百分之95响应时间： %s(ms)\n", ninetyFivePercentageResponseTime);
        System.out.printf("最小响应时间： %s(ms)\n", minPercentageResponseTime);
        System.out.printf("最大响应时间： %s(ms)\n", maxPercentageResponseTime);
        System.out.printf("请求成功次数： %s次\n", requestSucceedNum);
        System.out.printf("请求失败次数： %s次\n", requestFailedNum);
    }
}
