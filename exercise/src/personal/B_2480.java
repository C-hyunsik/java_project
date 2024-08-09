package personal;

import java.util.Scanner;

public class B_2480 {		//주사위 세개

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		if(n1 == n2 && n1 == n3) {
			System.out.println(10000 + (n1 * 1000));
		}
		else if(n1 == n2 || n1 == n3) {
			System.out.println(1000 + (n1 * 100));
		}
		else if(n2 == n3) {
			System.out.println(1000 + (n2 * 100));
		}
		else if(n1 != n2 && n1 != n3 && n2 != n3) {
			if(n1 > n2 && n1 > n3) {
				System.out.println(100*n1);
			}
			else if(n2 > n1 && n2 > n3) {
				System.out.println(100*n2);
			}
			else if(n3 > n1 && n3 > n1) {
				System.out.println(100*n3);
			}
		}
		sc.close();
	}

}
