package com.marcus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ObjectSaver {
	
	private static ObjectOutputStream out = null;
	private static ObjectInputStream in = null;
	
	private static String filePath = "E:\\objectFile.obj";
	
	public static void write(String obj1, Date obj2, Customer customer) throws Exception {
		out = new ObjectOutputStream(new FileOutputStream(filePath));		
		out.writeObject(obj1);
		out.writeObject(obj2);
		out.writeObject(customer);	
		out.writeInt(123);
		out.close();
	}
	
	
	public static void read(String obj1, Date obj2, Customer customer) throws Exception {
		in = new ObjectInputStream(new FileInputStream(filePath));
		String obj11 = (String) in.readObject();
		System.out.println("obj1: " + obj1);
		Date obj22 = (Date) in.readObject();
		System.out.println("obj2: " + obj2);
		Customer customer2 = (Customer) in.readObject();
		System.out.println("customer2: " + customer2);
		System.out.println(customer == customer2);
		int var = in.readInt();
		System.out.println("var: " + var);
		in.close();
	}
	public static void main(String[] args) throws Exception {
		String obj1 = "hello";
		Date obj2 = new Date();
		Customer customer = new Customer("Tom", 20);
		write(obj1, obj2, customer);
		read(obj1, obj2, customer);
	}
}


class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1791502352505791199L;
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "name=" + name + " age" + age;
	}
}