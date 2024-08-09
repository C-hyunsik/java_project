package compute;

import java.util.Scanner;

public class Sub implements Compute{
	private int x, y;
	public Sub() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x의 값 입력 : ");
		x = sc.nextInt();
		System.out.print("y의 값 입력 : ");
		y = sc.nextInt();
	}
	public void excute() {
		System.out.println(x + " - " + y + " = " + (x - y));
	}
}
