package book2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceT {
	private List<BookDTOT> list = new ArrayList<BookDTOT>();
	
	public void menu() throws IOException, ClassNotFoundException {
		while(true) {
			Scanner scan = new Scanner(System.in);
			int num;
			BookT bookT = null;
			System.out.println();
			System.out.println("***************************");
			System.out.println("1. 등록\n"
							 + "2. 출력\n"
							 + "3. 파일 저장\n"
							 + "4. 파일 읽기\n"
							 + "5. 책 제목으로 오름차순\n"
							 + "6. 책 제목 검색\n"
							 + "7. 끝");
			System.out.println("***************************");
			System.out.print("번호 선택 : ");
			num = scan.nextInt();
			
			if(num == 7) break;
			
			else if(num == 1) {
				bookT = new BookInsertT();
			}
			else if(num == 2) {
				bookT = new BookPrintT();
			}
			else if(num == 3) {
				bookT = new BookFileWriteT();
			}
			else if(num == 4) {
				bookT = new BookFileReadT();
			}
			else if(num == 5) {
				bookT = new BookTitleAscT();
			}
			else if(num == 6) {
				bookT = new BookTitleSearchT();
			}
			else {
				System.out.println("1 ~ 7 중에서 입력하세요");
				continue;
			}
			bookT.execute(list);	//호출
		}//while
	}//menu
}
