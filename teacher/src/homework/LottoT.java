package homework;

import java.util.Arrays;
import java.util.Scanner;

public class LottoT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] lotto = new int[6];
		
		System.out.print("현금 입력 : ");
		int money = sc.nextInt();
		
		for(int k =1; k<=money / 1000; k++) {
			//난수 발생
			for(int i = 0; i<lotto.length; i++) {
				lotto[i] = (int)(Math.random() * 45 + 1);
			
				//중복체크
				for(int j = 0; j < i; j++) {
					if(lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}//for j
			}//for i
			//오름차순
			Arrays.sort(lotto);
			//출력
			for(int data : lotto) {
				System.out.print(String.format("%5d", data) + "  ");
			}
			System.out.println();
			
			if(k % 5 == 0) System.out.println();
		}//for k
		sc.close();
	}
}
