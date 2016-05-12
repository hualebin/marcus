package com.marcus.string;

import java.util.Arrays;

public class Splitting {
	public static String knights = "Then, when you have found the shrubbery, you must "
									+ "cut down the mightiest tree in the forest...";
	public static void split(String regx) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(knights.split(regx)));
	}
	
	public static void main(String[] args) {
		split(" ");
		split("\\W+");
		split(",\\W+");
	}
}
