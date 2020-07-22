package org.marcus.lib.all.test;

public class ConcurrencyTestResult {

    /**
     * 平均响应时间（毫秒）
     */
    private Long averageResponseTime;

    /**
     * 95%响应时间（毫秒）
     */
    private Long ninetyFivePercentageResponseTime;

    /**
     * 最小响应时间（毫秒）
     */
    private Long minPercentageResponseTime;

    /**
     * 最大响应时间（毫秒）
     */
    private Long maxPercentageResponseTime;

    public ConcurrencyTestResult() {

    }

    public ConcurrencyTestResult(Long averageResponseTime, Long ninetyFivePercentageResponseTime, Long minPercentageResponseTime, Long maxPercentageResponseTime) {
        this.averageResponseTime = averageResponseTime;
        this.ninetyFivePercentageResponseTime = ninetyFivePercentageResponseTime;
        this.minPercentageResponseTime = minPercentageResponseTime;
        this.maxPercentageResponseTime = maxPercentageResponseTime;
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

    public void print() {
        if (averageResponseTime != null) {
            System.out.printf("平均响应时间： %s(ms)\n", averageResponseTime);
        }
        if (ninetyFivePercentageResponseTime != null) {
            System.out.printf("95%响应时间： %s(ms)\n", ninetyFivePercentageResponseTime);
        }
        if (minPercentageResponseTime != null) {
            System.out.printf("最小响应时间： %s(ms)\n", minPercentageResponseTime);
        }
        if (maxPercentageResponseTime != null) {
            System.out.printf("最大响应时间： %s(ms)\n", maxPercentageResponseTime);
        }
    }
}
