package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukUpdate implements SungJuk {
	int n, kor, eng, math;
	String name;
	SungJukDTO sungJukDTO = new SungJukDTO();
	public SungJukUpdate(ArrayList<SungJukDTO> list) {
		
	}

	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호 입력 : ");
		n = sc.nextInt();
		SungJukDTO target = null;
		for(SungJukDTO dto : list) {
			if(dto.getNo() == n) {
				target = dto;
				break;
			}
		}
		
			if(target == null) {
				System.out.println("잘못된 번호 입니다.");
				return;
			}
			else {
				
				System.out.println(target);
				
				
				System.out.print("수정할 이름 입력 : ");
				name = sc.next();
				target.setName(name);
				System.out.print("수정할 국어 입력 : ");
				kor = sc.nextInt();
				target.setKor(kor);
				System.out.print("수정할 영어 입력 : ");
				eng  = sc.nextInt();
				target.setEng(eng);
				System.out.print("수정할 수학 입력 : ");
				math  = sc.nextInt();
				target.setMath(math);
				target.setNo(n);
				target.calc();
		}
	}
}
