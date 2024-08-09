package compute;

import java.util.Scanner;

public class ComputeService {
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		Compute com = null;		//부모는 new 필요 x
		while(true) {
			System.out.println();
			System.out.println("**************");
			System.out.println("\t1. 합");
			System.out.println("\t2. 차");
			System.out.println("\t3. 곱");
			System.out.println("\t4. 몫");
			System.out.println("\t5. 끝내기");
			System.out.println("**************");
			System.out.print("\t번호 : ");
			num = sc.nextInt();
			
			if(num == 5) break;
			if(num == 1) {
				com = new Sum();	//생성
			}
			else if(num == 2) {
				com = new Sub();
			}
			else if(num == 3) {
				com = new Mul();
			}
			else if(num == 4) {
				com = new Div();
			}
			else {
				System.out.println("1 ~ 5 사이의 숫자만 입력하세요 : ");
			}
			com.excute();
		}
	}//menu
}
