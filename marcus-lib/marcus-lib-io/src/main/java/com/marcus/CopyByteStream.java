package com.marcus;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyByteStream {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("f:\\test.png");
		FileOutputStream fos = new FileOutputStream("f:\\test_new.png");
		
		byte[] bytes = new byte[1024];
		
		while (fis.read(bytes) != -1) {
			fos.write(bytes);
		}
		fis.close();
		fos.close();
	}
}
