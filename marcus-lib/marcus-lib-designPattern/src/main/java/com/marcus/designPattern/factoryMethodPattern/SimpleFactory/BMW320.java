 package com.marcus.designPattern.factoryMethodPattern.SimpleFactory;

public class BMW320 extends BMW{

	public BMW320(String name) {
		super(name);
		System.out.println("制造一部" + name + "宝马车");
	}

}
 