package ceshi;

public class Demo {
	private int id;
	private String name;
	private int age;
	private double length;
	private String address;
	
	public Demo(){
		
	}
	
	public Demo(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Demo(int id, String name, int age, double length, String address){
		this.id = id;
		this.name = name;
		this.age = age;
		this.length = length;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
