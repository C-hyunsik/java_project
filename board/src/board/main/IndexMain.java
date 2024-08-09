package board.main;

import java.util.Scanner;

import board.service.Board;
import board.service.BoardListService;
import board.service.BoardViewService;
import board.service.BoardWriteService;

public class IndexMain {

	public void menu() {
		Scanner sc = new Scanner(System.in);
		Board board = null;
		while(true) {
			System.out.println("******************");
			System.out.println("  1. 글쓰기");
			System.out.println("  2. 목록");
			System.out.println("  3. 작성한 글 내용 보기");
			System.out.println("  4. 끝");
			System.out.println("******************");
			System.out.print(" 번호 : ");
			int n = sc.nextInt();

			if(n == 4) break;
			
			if(n == 1) {
				board = new BoardWriteService();
			}
			else if(n == 2) {
				board = new BoardListService();
			}
			else if(n == 3) {
				board = new BoardViewService();
			}
			else {
				System.out.println("1 ~ 4 중에서 입력하세요");
				continue;
			}
			board.execute();
		}
	}

	public static void main(String[] args) {
		IndexMain indexMain = new IndexMain();
		indexMain.menu();
		System.out.println("프로그램이 종료되었습니다.");
	}

}
