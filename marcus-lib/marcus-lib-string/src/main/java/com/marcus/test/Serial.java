package com.marcus.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serial implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8276890896864305609L;
	
	int id;
	String name;
	
	public Serial(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "DATA" + id + " " + name;
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pageNo", "1");
		map.put("pageSize", "10");
		map.put("user_id", "9d9a62b24e214f0d9f3670d3c7ef0ed4");
		map.put("uri_method", "api_v2_projectInfo_list");
		map.put("timestamp", "2016-09-19 11:46:38");
		map.put("sign_method", "md5");
		List<String> list = new ArrayList<String>();
		for (String key : map.keySet()) {
			list.add(key);
		}
		Collections.sort(list);
		System.out.println(list.toString());
	}
}
