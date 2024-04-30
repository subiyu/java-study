package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileReaderTest {
	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;
		InputStreamReader isr = null;
		
		try {
			in = new FileReader("test.txt");
			is = new FileInputStream("test.txt");
			isr = new InputStreamReader(is, "UTF-8");
			
			int count = 0;
			int data = -1;
			
			/* while((data = in.read()) != -1) {
				System.out.print((char)data);
				count ++;
			} */
			
			while((data = isr.read()) != -1) {
				System.out.print((char)data);
				count ++;
			}
			
			System.out.println("");
			System.out.println("count: " + count);
			System.out.println("========================");
			
			count = 0;
			data = -1;
			
			while((data = is.read()) != -1) {
				System.out.print((char)data);
				count ++;
			}
			
			System.out.println("");
			System.out.println("count: " + count);
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if(in != null) {
					in.close();
				}
				if(is != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
