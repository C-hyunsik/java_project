package book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
	private ArrayList<BookDTO> list = new ArrayList<BookDTO>();
	
	public void menu() throws IOException, ClassNotFoundException {
		while(true) {
			System.out.println();
			Scanner sc = new Scanner(System.in);
			Book book = null;
			
			System.out.println("1. 등록\n"
							 + "2. 출력\n"
							 + "3. 파일 저장\n"
							 + "4. 파일 읽기\n"
							 + "5. 책 제목으로 오름차순\n"
							 + "6. 책 제목 검색\n"
							 + "7. 끝");
			System.out.print("번호 입력 : ");
			int n = sc.nextInt();
			
			if(n == 7) break;
			
			else if(n == 1) {
				book = new BookInsert();
			}
			else if(n == 2) {
				book = new BookPrint();
			}
			else if(n == 3) {
				book = new BookFileWrite();
			}
			else if(n == 4) {
				book = new BookFileRead();
			}
			else if(n == 5) {
				book = new BookTitleAsc();
			}
			else if(n == 6) {
				book = new BookTitleSearch();
			}
			else {
				System.out.println("1 ~ 7 중에서 입력하세요");
				continue;
			}
			book.execute(list);
		}
	}
}
