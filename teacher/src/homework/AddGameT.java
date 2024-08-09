package homework;

import java.util.Scanner;

public class AddGameT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		int dab;
		int count = 0;
		String yn;
		
		while(true) {
			count = 0;	//초기화
			
			for(int i = 1; i <= 5; i++) {	//5문제
				a = (int)(Math.random() * 90 + 10);		//10~99
				b = (int)(Math.random() * 90 + 10);		//10~99
				
				for(int j = 1; j <= 2; j++) {
					System.out.print("[" + i + "] " + a + " + " + b + " = ");
					dab = sc.nextInt();
					
					if(dab== a+b) {
						System.out.println("정답입니다.");
						count++;
						break;		//for j 벗어나라
					}
					else {
						if(j==2) {
							System.out.println("오답입니다. 정답은 " + (a + b));		//두 번 다 틀렸을때 
						}
						else
							System.out.println("오답입니다.");
					}
				}//for j
			}//for i
			System.out.println();
			System.out.println("당신은 총 " + count +" 문제를 맞추어서 점수 " + count*20 + "점 입니다.");
			
			System.out.println();
			do {
				System.out.print("또 할래(Y/N) : ");
				yn = sc.next();
			}while(!yn.equals("Y") && !yn.equals("y") && !yn.equals("N") && !yn.equals("n"));
			
			if(yn.equals("N") || yn.equals("n")) break; //문자열이기 때문에 ==비교 불가 '변수.equals()'함수 사용
		}//while
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
}
