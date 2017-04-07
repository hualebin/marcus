package org.marcus.lib.all.jdk8;

public class Outer {
	
	private int b = 3;
	
	public void doSomething() { 
		final int a = 10;
		class Inner {
			public void seeOuter() {
				System.out.println(a + b);
			}
		}
		
		Inner inner = new Inner();
		
		inner.seeOuter();
	}
	
	
	public static void main(String args[]) {
		Outer outer = new Outer();
		outer.doSomething();
	}

}
