package com.marcus.jersey.entity;

import java.util.HashMap;
import java.util.Map;

public class UserCache {
	private static Map<String, User> userCache;
	private static UserCache instance = null;
	
	private UserCache () {
		userCache = new HashMap<String, User>();
		initOneUser();
	}
	
	public static Map<String, User> getUserCache() {
		if (instance == null) {
			synchronized (UserCache.class) {
				if (instance == null) {
					instance = new UserCache();
				}
			}			
		}
		return userCache;
	}
	
	private static void initOneUser() {
		User user = new User("001", "marcus", 24);
		userCache.put(user.getUserId(), user);
	}
}
