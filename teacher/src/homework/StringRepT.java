package homework;

import java.util.Scanner;

public class StringRepT {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("문자열 입력 : ");
		String inputstr = scan.next().toLowerCase();
		System.out.print("현재 문자열 입력 : ");
		String targetstr = scan.next().toLowerCase();
		System.out.print("바꿀 문자열 입력 : ");
		String changestr = scan.next();
		
		if(inputstr.length() < targetstr.length()) {
			System.out.println("입력한 문자열의 크기가 작습니다");
		}
		else {
			int index = 0;
			int count = 0;
			
			while((index = inputstr.indexOf(targetstr,index)) != -1) {
				
				index += targetstr.length();
				count++;
			}//while
			
			System.out.println(inputstr.replace(targetstr,changestr));
			System.out.println(count + "번 치환");
			
		}//else
		scan.close();
	}

}
