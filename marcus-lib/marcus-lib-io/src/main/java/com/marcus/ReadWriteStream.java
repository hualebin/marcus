package com.marcus;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadWriteStream {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("F:\\test.txt");
		byte[] bytes = new byte[22];
		
		fis.read(bytes);
		System.out.println("kaisi");
		String inputString = new String(bytes, "GBK");
		System.out.println(inputString);
		fis.close();
		
		FileOutputStream fos = new FileOutputStream("F:\\testWrite.txt");
		
		fos.write(new String("测试编码").getBytes("utf-8"));
		fos.close();
	}

}
