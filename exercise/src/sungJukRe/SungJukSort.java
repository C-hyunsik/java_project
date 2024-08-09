package sungJukRe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SungJukSort implements SungJuk {

	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		Scanner sc = new Scanner(System.in);
		int n;

		System.out.println();
		while(true) {
			System.out.println("********************");
			System.out.println("1. 총점으로 내림차순");
			System.out.println("2. 이름으로 오름차순");
			System.out.println("3. 이전 메뉴");
			System.out.println("********************");
			System.out.print("번호 입력 : ");
			n = sc.nextInt();

			if(n == 3) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			}
			else if (n == 1) {
				Collections.sort(list);
				System.out.println("정렬이 완료되었습니다.");
			}
			else if (n == 2) {
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {

					@Override
					public int compare(SungJukDTO s1, SungJukDTO s2) {
						return s1.getName().compareTo(s2.getName());
					}
				};
				Collections.sort(list,com);
				System.out.println("정렬이 완료되었습니다.");
			}
			else System.out.println("1 ~ 3 중에서 입력하세요");
			continue;
		}//while
	}

}
