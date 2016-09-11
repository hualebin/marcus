package com.marcus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestRWCharStream {
	public static void main(String[] args) {
		File file = new File("f:\\testWrite.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream("f:\\testRead.txt");
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			char[] chars = new char[100];
			int l = 0;
			while ((l = isr.read(chars)) != -1) {
				System.out.println(new String(chars, 0, l));
				osw.write(chars, 0, l);
			}
			fis.close();
			isr.close();
			osw.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}
