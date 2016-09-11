package com.marcus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class RWByBufferedCharStream {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("f:\\testWrite.txt");
			FileOutputStream fos = new FileOutputStream("f:\\test1.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			PrintWriter pw = new PrintWriter(fos, true);
			String readMsg = null;
			while ((readMsg = br.readLine()) != null) {
				System.out.println(readMsg);
				//bw.write(readMsg);
				pw.println(readMsg);
			}
			
			//pw.flush();
			br.close();
			pw.close();
			fis.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
