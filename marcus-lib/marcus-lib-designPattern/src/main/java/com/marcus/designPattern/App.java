package com.marcus.designPattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        Apple apple1 = new Apple("红苹果");
        Apple apple2 = new Apple("青苹果");
        
        new Thread(apple1).start();
        
        
        
        apple1.printType();
        apple2.printType();
        
    }
}

class Apple implements Runnable {
	public static String type;
	
	public String name;
	
	public Apple() {
		
	}
	
	public Apple(String name) {
		this.name = name;
	}
	
	public void test() {
		type = name;
	}
	
	public void printType() {
		System.out.println(type);
	}

	@Override
	public void run() {
		test();
	}
}
