package com.marcus;

import java.util.List;

import redis.clients.jedis.Jedis;

public class ReidsJava {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("120.24.166.171", 6379);
		//jedis.auth("marcus");
		System.out.println("Connection to server successfully");
		System.out.println("Server is running:" + jedis.ping());
		System.out.println(jedis.get("name"));
		
		
		/*//设置redis字符串数据
		jedis.set("name", "marcus");
		
		//获取数据
		System.out.println("Stroed string in redis::" + jedis.get("name"));
		
		//存储数据到列表中
		jedis.lpush("test-list", "redis");
		jedis.lpush("test-list", "redis-1");
		jedis.lpush("test-list", "redis-2");
		
		//获取列表中的数据
		List<String> list = jedis.lrange("test-list", 0, 5);
		for(String str : list){
			System.out.println("Stroed string in redis ::" + str);
		}*/
	}
}
