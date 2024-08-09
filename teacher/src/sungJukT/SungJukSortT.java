package sungJukT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SungJukSortT implements SungJukT{

	@Override
	public void execute(ArrayList<SungJukDTOT> list) {
		Scanner scan = new Scanner(System.in);
		
		int num;
		while(true) {
			System.out.println();
			System.out.println("********************");
			System.out.println("1. 총점으로 내림차순");
			System.out.println("2. 이름으로 오름차순");
			System.out.println("3. 이전 메뉴");
			System.out.println("********************");
			System.out.print("번호 입력 : ");
			num = scan.nextInt();
			if(num == 3) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			}
			else if(num == 1) {
				Collections.sort(list);
				System.out.println("총점으로 내림차순하였습니다.");
			}
			else if(num == 2) {
				Comparator<SungJukDTOT> com = new Comparator<SungJukDTOT>() {
					@Override
					public int compare(SungJukDTOT s1, SungJukDTOT s2) {
						return s1.getName().compareTo(s2.getName());
					}};
					Collections.sort(list,com);
					System.out.println("이름으로 오름차순하였습니다."); 
				
			}
			else {
				System.out.println("1 ~ 3중에서 선택하세요.");
				continue;
			}
		}
	}
}
