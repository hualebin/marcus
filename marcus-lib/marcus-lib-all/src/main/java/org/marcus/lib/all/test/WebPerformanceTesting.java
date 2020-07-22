package org.marcus.lib.all.test;

public interface WebPerformanceTesting {

    /**
     * 并发测试
     *
     * @param url 请求URL
     * @param concurrencyNum 并发次数
     * @param requestTotal 请求总次数
     */
    public ConcurrencyTestResult concurrencyTest(String url, int concurrencyNum, int requestTotal);

}
