package homework;

import java.util.Scanner;

public class ParkingT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] ar = new boolean[5];
		int num;
		
		while(true) {
			System.out.println("주차장 관리 프로그램");
			System.out.println("**************");
			System.out.println("   1. 입차");
			System.out.println("   2. 출차");
			System.out.println("   3. 리스트");
			System.out.println("   4. 종료");
			System.out.println("**************");
			
			System.out.print(" 메뉴 : ");
			num = sc.nextInt();
			if(num == 4) break;
			if(num == 1) {
				System.out.print("위치 입력 : ");
				int pos = sc.nextInt();
				if(ar[pos]) {
					System.out.println(pos + "번 위치에 입차 / 이미 주차되어있습니다");
				}
				else {
					ar[pos-1] = true;
					System.out.println(pos + "번 위치에 입차되었습니다.");
				}
			}
			else if(num == 2) {
				System.out.print("위치 입력 : ");
				int pos = sc.nextInt();
				if(ar[pos-1]) {
					ar[pos-1] = false;
					System.out.println(pos + "번 위치에서 출차되었습니다.");
				}
				else {
					System.out.println(pos + "번 위치에서 출차 / 주차되어 있지않습니다.");
				}
			}
			else if(num == 3) {
				System.out.println();
				for(int i =0; i < ar.length; i++) {
					System.out.println((i+1) + "번 위치 : " + ar[i]);
				}		
			}
			else {
				System.out.println("1 ~ 4번까지만 입력하세요.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}

}
