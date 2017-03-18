package org.marcus.lib.all;

import org.marcus.lib.all.jdk8.TestClass;

public class Test {
	
	public static void main(String args[]) {
		
		//匿名内部类
		new TestClass() {
			void callParentTest() {
				super.test();
			}
		}.callParentTest();
	}

}
