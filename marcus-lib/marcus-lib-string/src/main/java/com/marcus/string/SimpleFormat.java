package com.marcus.string;

public class SimpleFormat {
	public static void main(String args[]){
		int x = 5;
		double y = 5.332542;
		// the old way
		System.out.println("Row1 : [" + x + ", " + y + "]" );
		// the new way
		System.out.format("Row1 : [%d, %f]\n", x, y);
		//or
		System.out.printf("Row1 : [%d, %f]\n", x, y);
	}
	
	

}
