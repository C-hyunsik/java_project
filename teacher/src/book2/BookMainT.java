package book2;

import java.io.IOException;

public class BookMainT {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		BookServiceT bookServiceT = new BookServiceT();
		
		bookServiceT.menu();
		
		System.out.println("프로그램을 종료합니다.");

	}

}
