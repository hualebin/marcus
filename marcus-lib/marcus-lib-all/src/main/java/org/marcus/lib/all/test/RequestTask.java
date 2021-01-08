package org.marcus.lib.all.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/**
 * 请求任务
 *
 */
public class RequestTask implements Callable<RequestTaskResult> {

	private String url;

	private String method;

	public RequestTask(String url, String method) {
		this.url = url;
		this.method = method;
	}

	@Override
	public RequestTaskResult call() {
		HttpURLConnection connection = null;
		RequestTaskResult result = new RequestTaskResult();
		Long responseTime = 0L;
		Boolean requestSuccess = false;
		try {
			long startTime = System.currentTimeMillis();
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod(method);
			connection.connect();

			int code = connection.getResponseCode();
			if (code == 200) {
				responseTime = System.currentTimeMillis() - startTime;
				requestSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

		result.setRequestSuccess(requestSuccess);
		result.setResponseTime(responseTime);

		return result;
	}
}
