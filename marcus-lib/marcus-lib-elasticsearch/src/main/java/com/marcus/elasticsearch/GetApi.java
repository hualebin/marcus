package com.marcus.elasticsearch;

import java.net.UnknownHostException;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;

public class GetApi {
	public static void main(String[] args) {
		try {
			TransportClient client = Connection.connect();
			GetResponse response = client.prepareGet("twitter", "tweet", "1")
					.setOperationThreaded(false)
					.get();
			System.out.println(response.getSourceAsString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} finally {
			Connection.close();
		}
	}
}
