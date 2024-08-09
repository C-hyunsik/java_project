package personal;

import java.util.Scanner;

public class B_10872 {			//팩토리얼

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 1;
		for(int i = 1; i <= N; i++){
			result = i*result;
		}
		System.out.println(result);
		sc.close();
	}
}
