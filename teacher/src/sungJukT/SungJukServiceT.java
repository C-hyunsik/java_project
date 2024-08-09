package sungJukT;

import java.util.ArrayList;
import java.util.Scanner;


public class SungJukServiceT {
	private ArrayList<SungJukDTOT> list = new ArrayList<SungJukDTOT>();
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		int num;
		SungJukT sungJukT = null;
		
		while(true) {
			
			System.out.println();
			System.out.println("\t1. 입력");
			System.out.println("\t2. 출력");
			System.out.println("\t3. 수정");
			System.out.println("\t4. 삭제");
			System.out.println("\t5. 정렬");
			System.out.println("\t6. 종료");
			System.out.print("\t숫자 입력 : ");
			num = scan.nextInt();
			
			if(num==6) break;
			else if(num == 1){
				sungJukT = new SungJukInsertT();
				//System.out.println(list);
			}
			else if(num == 2){
				sungJukT = new SungJukPrintT();
			}
			else if(num == 3) {
				sungJukT = new SungJukUpdateT();
			}
			else if(num == 4) {
				sungJukT = new SungJukDeleteT();
			}
			else if(num == 5) {
				sungJukT = new SungJukSortT();
			}
			else {
				System.out.println("1 ~ 6중에 선택하세요");
				continue;
			}
			sungJukT.execute(list);
			}//while
	}//menu
}
