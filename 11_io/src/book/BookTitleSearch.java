package book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTitleSearch implements Book {
	
	@Override
	public void execute(ArrayList<BookDTO> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		System.out.print("검색할 책 제목을 입력하세요 : ");
		String title = sc.next();
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().toLowerCase().indexOf(title) != -1 || list.get(i).getTitle().toUpperCase().indexOf(title) != -1) {
				System.out.println(list.get(i));
				count++;
			}
		}//for
		if(count == 0) {
			System.out.println("해당하는 책이 없습니다.");
		}
	}

}
