package org.marcus.lib.all.jvm;

/**
 * NotInitialization
 *
 * @author marcus
 * @date 2020-10-26
 */
public class NotInitialization {
	public static void main(String[] args) {
		// System.out.println(SubClass.name);
		SubClass[] subClasses = new SubClass[10];
	}
}
