package book2;

import java.util.List;
import java.util.Scanner;

public class BookTitleSearchT implements BookT {
	
	@Override
	public void execute(List<BookDTOT> list) {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.print("검색할 책 제목을 입력하세요 : ");
		String title = scan.next().toLowerCase();
		
		int sw = 0;
		for(BookDTOT bookDTOT : list) {
			if(bookDTOT.getTitle().toLowerCase().contains(title)) {
				System.out.println(bookDTOT);
				sw = 1;
			}
		}//for
		if(sw == 0) {
			System.out.println("검색한 책이 없습니다.");
		}
	}
}