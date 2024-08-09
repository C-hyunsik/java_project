package book2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookTitleAscT implements BookT {

	@Override
	public void execute(List<BookDTOT> list) {
		System.out.println();
		
		Comparator<BookDTOT> com = new Comparator<BookDTOT>() {

			@Override
			public int compare(BookDTOT b1, BookDTOT b2) {
				return b1.getTitle().compareTo(b2.getTitle());
			}
		};
		Collections.sort(list,com);
		System.out.println("책 이름으로 오름차순 정렬이 완료되었습니다.");
		System.out.println("코드\t제목\t저자\t가격\t수량\t합계");
		for(BookDTOT bookDTOT : list) {
			System.out.println(bookDTOT);
		}
		
	}

}
