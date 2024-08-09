package book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookInsert implements Book {
	Scanner sc = new Scanner(System.in);
	@Override
	public void execute(ArrayList<BookDTO> list) {
		System.out.println();
		
		System.out.print("코드 입력 : ");
		int code = sc.nextInt();
		System.out.print("책제목 입력 : ");
		String title = sc.next();
		System.out.print("저자 입력 : ");
		String author = sc.next();
		System.out.print("단가 입력 : ");
		int price = sc.nextInt();
		System.out.print("개수 입력 : ");
		int qty = sc.nextInt();
		
		BookDTO bookDTO = new BookDTO(code, price, qty, title, author);
		list.add(bookDTO);
		bookDTO.calc();
		System.out.println("책을 등록하였습니다.");
	}

}
