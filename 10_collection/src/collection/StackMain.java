package collection;

import java.util.Stack;

import static java.lang.System.out;

public class StackMain {

	public static void main(String[] args) {
		String[] groupA = {"우즈베키스탄", "쿠웨이트", "사우디", "대한민국"};
		
		Stack<String> stack = new Stack<String>();
		
		for(int i = 0; i < groupA.length; i++)
			stack.push(groupA[i]);		//push : 그룹에 데이터를 i번째부터 입력
		
		while( ! stack.isEmpty() )		//스택이 비어있지 않다면
			out.println( stack.pop());	//pop : 스택안의 데이터를 꺼내옴

	}

}
