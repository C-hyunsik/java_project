package book2;

import java.util.List;

public class BookPrintT implements BookT {
	BookDTOT bookDTOT = new BookDTOT();
	@Override
	public void execute(List<BookDTOT> list) {
		System.out.println();
		System.out.println("등록된 책의 리스트를 출력합니다.");
		System.out.println("코드\t책제목\t저자\t단가\t개수\t합계");
		
		for(BookDTOT bookDTOT : list) {
			System.out.println(bookDTOT);
		}		
	}

}
