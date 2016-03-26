package com.marcus.test;

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
}
