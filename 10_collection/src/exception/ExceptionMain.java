package exception;

import java.util.Scanner;

public class ExceptionMain {

	public static void main(String[] args) {
		//ArrayIndexOutOfBoundsException 0번째 방에 배열값이 없다.
		//System.out.println("args[0] = " + args[0]);
		if(args.length != 0)System.out.println("args[0] = " + args[0]);
		System.out.println();
		//NumberFormatException: For input string: "호랑이" = 호랑이는 숫자가 아니기 때문에 int로 바꾸지 못함.
		//int num1 = Integer.parseInt(args[0]);
		
		try {	//error가 나지 않으면 try문을 실행 error가 날 경우 catch로 가서 내용을 실행
			int num1 = Integer.parseInt(args[0]);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("숫자 입력 : ");
			//ArithmeticException: / by zero 0입력시 0으로 나눌 수 없다 error발생
			int num2 = sc.nextInt();
			
			System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
		}
		catch(NumberFormatException e) {	//num1이 숫자형식이 아닐 때 실행
			System.out.println("숫자 형식으로 넣으세요.");
			e.printStackTrace();
		}
		catch(ArithmeticException e) {		//입력받은 num2가 0일 때 실행
			System.out.println("0으로 나눌 수 없습니다.");
			e.printStackTrace();
		}
		finally {
			System.out.println("error가 있건 없건 무조건 실행!!");
		}
	}
}