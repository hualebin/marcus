package com.marcus;

public class Person {
    String name;

    public Person(String personName) {
        name = personName;
    }

    public String greet(String yourName) {
        return String.format("Hi %s, my name is %s", name, yourName);
    }
    
    public static void main(String[] args) {
		Person person = new Person("marcus");
		System.out.println(person.greet("li"));
		String str = "abcde";
		char c = str.charAt(1);
		String[] s = new String[]{"a", "e", "i"};
		char c1[] = str.toCharArray();
		char c2 = 'v';
		System.out.println(c == c2);
		System.out.println(c);
	}
    
}