package sungJukT;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukInsertT implements SungJukT{

	@Override
	public void execute(ArrayList<SungJukDTOT> list) {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("번호 입력 : ");
		int no = scan.nextInt();
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("국어 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		int math = scan.nextInt();
		
		SungJukDTOT sungJukDTOT = new SungJukDTOT(no, name, kor, eng, math);
		sungJukDTOT.calc();
		
		list.add(sungJukDTOT);
		System.out.println("입력되었습니다.");
	}

}
