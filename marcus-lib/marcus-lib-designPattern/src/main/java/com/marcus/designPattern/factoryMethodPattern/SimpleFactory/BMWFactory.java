package com.marcus.designPattern.factoryMethodPattern.SimpleFactory;

public class BMWFactory {
	
	public BMW createBMW(String name) {
		if ("BMW320".equals(name)) {
			return new BMW320(name);
		} else if ("BMW250".equals(name)) {
			return new BMW250(name);
		}
		return null;
	}

}
