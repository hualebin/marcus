package ceshi;

import java.lang.reflect.Method;

public class DumpMethods {
	
	public static void main(String args[]) throws ClassNotFoundException{
		Class cl = Class.forName("ceshi.Demo");
		Method[] methods = cl.getMethods();
		for(int i = 0; i < methods.length; i++){
			//System.out.println(methods[i].getName());
			System.out.println(methods[i].toString());
		}
	}

}
