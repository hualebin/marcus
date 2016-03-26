package com.marcus.string;

public class Serial implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9025087046091598497L;
	
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
