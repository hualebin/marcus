package com.marcus.elasticsearch;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class Connection {
	
	private static TransportClient client;
	
	public static TransportClient connect() throws UnknownHostException {
		Settings settings = Settings.settingsBuilder()
				.put("cluster.name", "my-application").build();
		client = TransportClient.builder().settings(settings).build()
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.137.116"), 9300))
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.137.117"), 9300))
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.137.118"), 9300));
		return client;
	}
	
	public static void close() {
		if (client != null) {
			client.close();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException {
		
	}

}
