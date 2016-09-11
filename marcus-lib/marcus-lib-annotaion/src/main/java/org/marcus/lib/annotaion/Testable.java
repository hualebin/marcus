package org.marcus.lib.annotaion;

public class Testable {
	
	public void execute() {
		System.out.println("Execting..");
	}
	@Test 
	public void testExecute() {
		execute();
	}

}
