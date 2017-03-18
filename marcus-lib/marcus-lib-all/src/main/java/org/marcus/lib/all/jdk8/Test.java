package org.marcus.lib.all.jdk8;

public class Test {
	
	public static void main(String args[]) {
		new Object() {
			void show() {
				System.out.println("show run");
			}
		}.show(); //编译通过
		
		Object obj = new Object() {
			void show() {
				System.out.println("show run");
			}
		};
		
		//obj.show(); 编译错误
		
		new TestClass().test();
	}

}
