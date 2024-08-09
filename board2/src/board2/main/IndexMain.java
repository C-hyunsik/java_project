package board2.main;

import java.util.Scanner;

import board2.service.Board2;
import board2.service.Board2ListService;
import board2.service.Board2ViewService;
import board2.service.Board2WriteService;

public class IndexMain {

	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		Board2 board2 = null;
		while(true) {
			System.out.println("******************");
			System.out.println("  1. 글쓰기");
			System.out.println("  2. 목록");
			System.out.println("  3. 작성한 글 내용 보기");
			System.out.println("  4. 종료");
			System.out.println("******************");
			System.out.print(" 번호 : ");
			int n = sc.nextInt();

			if(n == 4) break;

			else if(n == 1) {
				board2 = new Board2WriteService();
			}
			else if(n == 2) {
				board2 = new Board2ListService();
			}
			else if(n == 3) {
				board2 = new Board2ViewService();
			}
			else {
				System.out.println("1  ~ 4 중에서 선택하세요");
				continue;
			}
			board2.execute();
		}//while
	}
	public static void main(String[] args) {
		IndexMain indexMain = new IndexMain();
		System.out.println("집에서 연습용");
		indexMain.menu();
		System.out.println("프로그램을 종료합니다.");

	}

}
