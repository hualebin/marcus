package org.marcus.lib.all.test;

/**
 * 性能测试
 */
public interface WebPerformanceTesting {

    /**
     * 并发测试
     *
     * @param url 请求URL
     * @param method 请求方式
     * @param concurrencyNum 并发数
     * @param requestTotal 请求总次数
     */
    public ConcurrencyTestResult concurrencyTest(String url, String method, int concurrencyNum, int requestTotal);

}
