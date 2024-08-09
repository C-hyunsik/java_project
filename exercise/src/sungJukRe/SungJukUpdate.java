package sungJukRe;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukUpdate implements SungJuk {
	SungJukDTO sungJukDTO = new SungJukDTO();
	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		Scanner sc = new Scanner(System.in);
		int no, kor, eng, math;
		String name;
		
		System.out.println();
		System.out.println("번호 입력 : ");
		no = sc.nextInt();

		boolean sw = false;

		for(SungJukDTO sungJukDTO : list) {
			if(sungJukDTO.getNo() == no) {
				sw = true;
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTO);
				System.out.println();

				System.out.println("수정 할 이름 입력 : ");
				name = sc.next();
				System.out.println("수정 할 이름 입력 : ");
				kor= sc.nextInt();
				System.out.println("수정 할 이름 입력 : ");
				eng = sc.nextInt();
				System.out.println("수정 할 이름 입력 : ");
				math = sc.nextInt();

				sungJukDTO.setName(name);
				sungJukDTO.setKor(kor);
				sungJukDTO.setEng(eng);
				sungJukDTO.setMath(math);

				sungJukDTO.calc();
				System.out.println("수정하였습니다.");
				break;
			}//if
		}//for
		if(!sw) {
			System.out.println("잘못된 번호입니다.");
		}
	}

}
