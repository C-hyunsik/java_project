package book;

import java.util.ArrayList;
import java.util.Collections;

public class BookTitleAsc implements Book {

	@Override
	public void execute(ArrayList<BookDTO> list) {
		Collections.sort(list);
		System.out.println("책 이름으로 오름차순 정렬이 완료되었습니다.");
		
	}

}
