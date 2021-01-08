package org.marcus.lib.all.test;

/**
 * 请求任务结果
 *
 */
public class RequestTaskResult {

	private Long responseTime;

	private Boolean requestSuccess;

	public Long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

	public Boolean getRequestSuccess() {
		return requestSuccess;
	}

	public void setRequestSuccess(Boolean requestSuccess) {
		this.requestSuccess = requestSuccess;
	}
}
