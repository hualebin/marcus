package com.marcus.coding;

import java.util.Random;

/**
 * java开发中的通用方法和准则
 * @author Administrator
 *
 */
public class CodePartOne {
	
	public static void main(String[] args) {
		//建议一：不要在常量和变量中出现易混淆字母
		long i = 1l; //改正建议一 long i = 1L; o 和  O 易容易混淆
		System.out.println("i的两倍是:" + (i + i));
		
		//建议二：不要让常量蜕变成变量
		
		
		
		
	}

}

class Code {
	public static final Integer CODE_STATUS = new Random().nextInt();
}
