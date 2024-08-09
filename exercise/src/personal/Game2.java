package personal;

import java.io.IOException;
import java.util.Scanner;

public class Game2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가위(1), 바위(2), 보자기(3) 입력 : ");
		int pl = System.in.read() - 48;
		
		System.out.print("베팅금액 : ");
		int batt = sc.nextInt();
		int base_batt = 1000;
		
		System.out.println("결과를 보시려면 Enter를 치세요.");
		System.in.read();
		
		int com = (int)(Math.random() * 3 + 1);
		String com1 = "";
		String pl1 = "";
		switch(com){
		case 1 : com1 = "가위"; break;
		case 2 : com1 = "바위"; break;
		case 3 : com1 = "보자기"; break;			
		}
		switch(pl){
		case 1 : pl1 = "가위"; break;
		case 2 : pl1 = "바위"; break;
		case 3 : pl1 = "보자기"; break;		
		}
		if(com == pl) {
			System.out.println("컴퓨터는 " + com1 + " 나는 " + pl1);
			System.out.println("비겼다");
			System.out.println("현재 금액은 " + base_batt + "원");
		}
		else if((com == 1 && pl == 2) || (com == 2 && pl == 3) || (com == 3 && pl == 1)) {
			System.out.println("컴퓨터는 " + com1 + " 나는 " + pl1);
			System.out.println("이겼다");
			System.out.println("현재 금액은 " + (base_batt + batt) + "원");
		}
		else if((com == 1 && pl == 3) || (com == 2 && pl == 1) || (com == 3 && pl == 2)) {
			System.out.println("컴퓨터는 " + com1 + " 나는 " + pl1);
			System.out.println("졌다");
			System.out.println("현재 금액은 " + (base_batt - batt) + "원");
		}
		else {
			System.out.println("오류 : 정확한 숫자를 입력하세요");
		}
		sc.close();
	}
}
/*
[문제] 가위 바위 보 게임
-가위(1), 바위(2), 보자기(3)으로 설정한다.
-컴퓨터는 난수 1~3 사이의 숫자를 발생한다.
-기본 금액은 1000원을 기본으로 설정한다.
-System.in.read()를 사용하여 입력받는다.
[실행결과]
가위(1), 바위(2), 보자기(3) 입력 : 1		<- System.in.read()사용
베팅 금액 : 600

결과를 보시려면 Enter를 치세요.

컴퓨터는 바위, 나는 가위
ㅠㅠ.. 졌다
현재 금액은 400원
*/