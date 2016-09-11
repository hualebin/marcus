package com.marcus;

import java.io.File;

public class TestRandomAccessFile {
	static File file = new File("f:\\testRead.txt");
	
	public static void main(String[] args) {
		if (file.exists()) {
			file.delete();
		}
		
		new WriteFile(file, 1).start();
		new WriteFile(file, 2).start();
		new WriteFile(file, 3).start();
		new WriteFile(file, 4).start();
		new WriteFile(file, 5).start();
	}
}
