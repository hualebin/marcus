package com.marcus.elasticsearch;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;

public class IndexApi {
	public static void main(String[] args) {
		try {
			TransportClient client = Connection.connect();	//连接elasticsearch集群

			Map<String, Object> json = new HashMap<String, Object>();
			json.put("user", "kimchy");
			json.put("postDate", new Date());
			json.put("message", "trying out Elasticsearch");
			IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
					.setSource(json).get();
			
			String _index = response.getIndex();
			System.out.printf("索引_index: %s\n", _index);
			
			String _type = response.getType();
			System.out.printf("类型_type: %s\n", _type);
			
			String _id = response.getId();
			System.out.printf("ID值: %s\n", _id);
			
			long _version = response.getVersion();
			System.out.printf("版本号_version: %d\n", _version);
			
			boolean created = response.isCreated();
			System.out.println("索引是否创建成功:" + created);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} finally {
			Connection.close();
		}
	}
}
