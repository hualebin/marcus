package com.marcus.designPattern.observerPattern;

public class Test {
	
	private String id;
	private String name;
	private String status;
	
	public Test(String id, String name, String status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "id: " + id + "name: " + name + "status: " + status;
	}
	
	public static void main(String[] args) {
		Test t1 = new Test("123456", "marcus", "success");
		
		TestSubject testSubject = new TestSubject();
		testSubject.notify(t1);
	}

}
