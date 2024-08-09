package sungJukRe;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukService {
	public ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();
	int n;
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		SungJuk sj = null;
		
		while(true) {
			System.out.println();
			System.out.println(
							"\t1. 입력\n"
							+ "\t2. 출력\n"
							+ "\t3. 수정\n"
							+ "\t4. 삭제\n"
							+ "\t5. 정렬\n"
							+ "\t6. 끝");
			System.out.print("숫자 입력 : ");
			n = sc.nextInt();

			if(n == 6) break;
			else if (n == 1) {
				sj = new SungJukInsert();
			}
			else if (n == 2) {
				sj = new SungJukPrint();
			}
			else if (n == 3) {
				sj = new SungJukUpdate();
			}
			else if (n == 4) {
				sj = new SungJukDelete();
			}
			else if (n == 5) {
				sj = new SungJukSort();
			}
			else {
				System.out.println("1~6 중에서 입력하세요");
				continue;
			}
			sj.execute(list);
		}
	}
}
