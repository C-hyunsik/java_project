package book;

import java.util.ArrayList;

public class BookPrint implements Book {
	BookDTO bookDTO = new BookDTO();
	@Override
	public void execute(ArrayList<BookDTO> list) {
		System.out.println();
		System.out.println("등록된 책의 리스트를 출력합니다.");
		System.out.println("코드\t책제목\t저자\t단가\t개수\t합계");
		
		for(BookDTO bookDTO : list) {
			System.out.println(bookDTO);
		}
		
	}

}
