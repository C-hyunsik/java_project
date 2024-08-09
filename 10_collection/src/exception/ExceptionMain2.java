package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExceptionMain2 {
	private int x, y;

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("x 입력 : ");
		x = Integer.parseInt(br.readLine());
		System.out.print("y 입력 : ");
		y = Integer.parseInt(br.readLine());
	}

	public void output() {
		int mul = 1;
		if(y >= 0) {
			for(int i = 1; i <= y; i++) {
				mul *= x;
			}
			System.out.println(x + "의 " + y + "승은 " + mul + "입니다.");
		}
		else {
			//System.out.println("y는 0보다 크거나 같아야 한다");
			try {
				//throw new Exception("y는 0보다 크거나 같아야 한다");	//강제로 Exception을 발생
				throw new MakeException("y는 0보다 크거나 같아야 한다");
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}
	}


	public static void main(String[] args) throws IOException {
		ExceptionMain2 ex = new ExceptionMain2();
		ex.input();	//호출
		ex.output();
	}

}
/*
x값 입력 : 2
y값 입력 : 5		input()
-------------------------
2의 5승은 xx 		output()
 */