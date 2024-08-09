package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));

		int data;
		while((data = bis.read()) != -1) {
			System.out.print(data + " ");
			//65 66 67 68 13 10 49 50 51 52 13 10 61 45 42 47 
			//13, 10 -> 엔터 값		13 = \r = 맨 앞으로 이동		10 = \n = 줄 바꿈
		}
		bis.close();
	}

}
