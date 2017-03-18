package com.marcus.elasticsearch.partone;

import java.net.UnknownHostException;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;

import com.marcus.elasticsearch.Connection;

public class IndexApi {
	//创建索引
	public static void createIndex(TransportClient client) {
		
		client.admin().indices().prepareCreate("library1").get();
		client.admin().indices().prepareCreate("library2").setSettings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2)).get();
	}
	
	//更新索引文档
	public static void putIndexDocument(TransportClient client) {
		
	}
	
	//新增索引文档
	public static void postIndexDocument(TransportClient client) {
		
	}
	
	//获取索引文档
	public static void getIndexDocument(TransportClient client) {
		GetResponse getResponse = client.prepareGet("library", "book", "1").get();
		System.out.println(getResponse.getSourceAsString());
	}
	
	//删除索引文档
	public static void deleteIndexDocument(TransportClient client) {
		
	}
	
	//删除索引
	public static void deleteIndex(TransportClient client) {
		
	}
	
	public static void main(String[] args) {
		try {
			TransportClient client = Connection.connect();	//连接elasticsearch集群
			//createIndex(client);
			putIndexDocument(client);
			postIndexDocument(client);
			getIndexDocument(client);
			deleteIndexDocument(client);
			deleteIndex(client);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} finally {
			Connection.close();
		}
	}
}
