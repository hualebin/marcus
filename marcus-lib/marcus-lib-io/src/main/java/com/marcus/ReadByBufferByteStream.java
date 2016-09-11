package com.marcus;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadByBufferByteStream {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("f:\\caibab.zip");
		FileOutputStream fos = new FileOutputStream("f:\\caibab_new.zip");
		byte[] bytes = new byte[1024];
		
		long startTime = System.currentTimeMillis();
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		while (bis.read(bytes) != -1) {
			bos.write(bytes);
		}
		/*while (fis.read(bytes) != -1) {
			fos.write(bytes);
		}*/
		long endTime = System.currentTimeMillis();
		System.out.println("使用缓冲流进行读写花费的时间：" + (endTime - startTime));
	}
}
