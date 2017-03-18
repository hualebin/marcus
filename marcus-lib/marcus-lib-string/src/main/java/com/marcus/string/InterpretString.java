package com.marcus.string;

public class InterpretString {
	private static String str = "s";
	public static void main(String args[]){
		/**
		 * 情景一:字符串池(也叫常量池，是位于方法区中，是线程共享的)
		 * Java虚拟机中存在一个字符串池，其中保存很多String对象
		 * 由于是共享的，因此提高了效率
		 * 并且String类是final,它的值一经创建就不可更改
		 * 字符串值由String类维护，我们可以调用intern()方法来访问字符串池。
		 */
		String s1 = "abc";
		//↑ 在字符串池中创建一个对象
		String s2 = "abc";
		//↑ 字符串池中已经存在对象"abc"(共享),所以创建0个对象,累计创建一个对象
		System.out.println("s1 == s2: " + (s1 == s2)); 
		//↑ 指向同一个对象 true
		System.out.println("s1 == s2: " + (s1.equals(s2))); //true
		//↑ 值相等 true
		System.out.println("-----------------------------");
		
		/**
		 * 情景二：关于new String()创建字符串对象
		 */
		String s3 = new String("abc");
		//↑ 创建了两个对象, 一个存在字符串池, 一个存在堆内存中
		//↑ 还创建了对象引用s3放在栈中
		String s4 = new String("abc");
		//↑ 字符串池已经存在"abc"对象，创建了一个对象在堆内存中
		//↑ 还创建了对象引用s4放在栈中
		System.out.println("s3 == s4: " + (s3 == s4));
		//↑ s3和s4栈中地址不同，指向堆区不同的地址 false
		System.out.println("s3 == s4: " + (s3.equals(s4)));
		//↑ 值相等 true
		System.out.println("-----------------------------");
		
		System.out.println("s1 == s3: " + (s1 == s3));
		//↑ 存放的位置不同，一个存于堆中，一个存于字符串池
		System.out.println("s2 == s4: " + (s2.equals(s4)));
		//↑ 值相等 true
		
		System.out.println("-----------------------------");
		
		/**
		 * 情景三：关于字符串相加得到的对象
		 */
		String str1 = "abc" + "d"; //"abc"和"d"
		//↑ 创建一个String对象"abcd"，存储在字符串池中
		String str2 = "abcd";
		//↑ 在字符串池中已经存在，创建0个对象
		System.out.println("str1 == str2 : " + (str1 == str2));
		//↑ str1和str2都指向字符串池中的同一个对象，true
		
		System.out.println("-----------------------------");
		
		String str3 = "ab";
		String str4 = "cd";
		String str5 = str3 + str4;
		//↑ 首先虚拟机会在堆中创建一个StringBuilder对象，同时用str3指向的字符串池对象完成初始化
		String str6 = "abcd";
		System.out.println("str5 == str6 : " + (str5 == str6));
		System.out.println("-----------------------------");
		/** 
         * 情景五： 
         *  JAVA编译器对string + 基本类型/常量 是当成常量表达式直接求值来优化的。 
         *  运行期的两个string相加，会产生新的对象的，存储在堆(heap)中 
         */  
        String str66 = "b";  
        String str7 = "a" + str66;  
        String str67 = "ab";  
        System.out.println("str7 = str67 : "+ (str7 == str67));  
        //↑str6为变量，在运行期才会被解析。  
        final String str8 = "b";  
        String str9 = "a" + str8;  
        String str89 = "ab";  
        System.out.println("str9 = str89 : "+ (str9 == str89));  
        //↑str8为常量变量，编译期会被优化  
        String str10 = "s";
        System.out.println(str10 == str);
        //↑str为静态变量，编译期会被优化 
        //↑------------------------------------------------------over  
		
		Integer i1 = 127;
		Integer i2 = 127;
		System.out.println(i1 == i2);
		Double d1 = 2.53;
		Double d2 = 2.53;
		System.out.println(d1 == d2);
		
	}

}
