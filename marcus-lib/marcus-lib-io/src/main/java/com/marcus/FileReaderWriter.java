package com.marcus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("f:\\testRead.txt");
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("f:\\testWriter.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
				bw.write(msg + "\n");
			}
			bw.flush();
			
			bw.close();
			br.close();
			fw.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
