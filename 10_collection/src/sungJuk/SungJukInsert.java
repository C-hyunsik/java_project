package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukInsert implements SungJuk {
	Scanner sc = new Scanner(System.in);
	int no, kor, eng, math;
	String name;
	
	
	public SungJukInsert(ArrayList<SungJukDTO> list) {
		System.out.print("번호 입력 : ");
		no = sc.nextInt();
		System.out.print("이름 입력 : ");
		name = sc.next();
		System.out.print("국어 입력 : ");
		kor = sc.nextInt();
		System.out.print("영어 입력 : ");
		eng = sc.nextInt();
		System.out.print("수학 입력 : ");
		math = sc.nextInt();
	}

	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		SungJukDTO sungJukDTO = new SungJukDTO(no,name,kor,eng,math);
		sungJukDTO.calc();
		list.add(sungJukDTO);
		//System.out.println(sungJukDTO);	출력
	}

}
