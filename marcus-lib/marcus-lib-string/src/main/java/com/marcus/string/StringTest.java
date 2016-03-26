package com.marcus.string;

public class StringTest {
	
	public StringTest(){
		String str = "acd ef";
		System.out.println(str);
		System.out.println(str.trim());
		String str1 = " abcd";
		System.out.println(str1);
		System.out.println(str1.trim());
		String str2 = "abcd ";
		System.out.println(str2 + "cc");
		System.out.println(str2.trim() + "cc");
		//↑ trim()方法是去除字符串的首尾空格
		
		System.out.println(str.toUpperCase());
		String str3 = "n你";
		System.out.println(str3.toUpperCase());
		//↑toUpperCase()将小写字母转化为大写字母
	}
	
	public static void main(String args[]) {
		String s0 = "kvill";
		String str1 = new String("kvill");
		String str2 = new String("kvill");
		System.out.println(s0 == str1); //false
		System.out.println("--------------");
		str1.intern(); //执行了intern方法，查找常量池有没有相同的UNICODE的字符串常量，没有将返回引用赋给str1,依旧是堆中的引用
		str2 = str2.intern();//把常量池中的"kvill"的引用赋给str2
		System.out.println(str1 == str2);//false
		System.out.println(str1 == s0);//false
		System.out.println(str2 == s0);//true
		
		System.out.println("--------------");
		String str3 = new String("kill");
		String str4 = str3.intern();//常量池会产生一个新的地址
		
		System.out.println(str3 == str3.intern());//false
		System.out.println("str3=" + str3 + " str4=" + str4);
		System.out.println(str3 == str4);//false
		System.out.println(str4 == str3.intern());//true
		
		
	}

}
