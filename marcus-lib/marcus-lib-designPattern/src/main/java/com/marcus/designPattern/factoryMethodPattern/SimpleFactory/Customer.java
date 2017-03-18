package com.marcus.designPattern.factoryMethodPattern.SimpleFactory;

public class Customer {
	
	public static void main(String[] args) {
		BMWFactory factory = new BMWFactory();
		BMW bmw250 = factory.createBMW("BMW250");
		BMW bmw320 = factory.createBMW("BMW320");
	}

}
