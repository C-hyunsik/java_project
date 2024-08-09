package compute;

import java.util.Scanner;

public class Div implements Compute{
	private int x, y;
	public Div() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x의 값 입력 : ");
		x = sc.nextInt();
		System.out.print("y의 값 입력 : ");
		y = sc.nextInt();
	}
	@Override
	public void excute() {
		System.out.println(x + " / " + y + " = " + String.format("%.2f",((double)x / y)));
	}
	
}
