package book2;

import java.util.List;
import java.util.Scanner;

public class BookInsertT implements BookT {
	Scanner sc = new Scanner(System.in);
	@Override
	public void execute(List<BookDTOT> list) {
		System.out.println();
		
		System.out.print("코드 입력 : ");
		String code = sc.next();
		System.out.print("제목 입력 : ");
		String title = sc.next();
		System.out.print("저자 입력 : ");
		String author = sc.next();
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		System.out.print("수량 입력 : ");
		int qty = sc.nextInt();
		
		int total = price * qty;
		
		//DTO클래스의 생성자를 이용해 한번에 데이터 입력
		BookDTOT bookDTOT = new BookDTOT(code, title, author, price, qty);
		bookDTOT.setTotal(total);
		//list에 데이터 옮겨담기
		list.add(bookDTOT);
		System.out.println("항목을 추가하였습니다.");
	}

}
