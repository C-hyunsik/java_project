package sungJukT;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukUpdateT implements SungJukT{

	@Override
	public void execute(ArrayList<SungJukDTOT> list) {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("번호 입력 : ");
		int no = scan.nextInt();
		
		boolean sw = false;
		for(SungJukDTOT sungJukDTOT : list) {
			if(sungJukDTOT.getNo() == no) {		//입력받은 숫자가 데이터에 있는지 확인(중복없다 가정)
				sw = true;
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTOT);
				System.out.println();
				
				System.out.print("수정할 이름 입력 : ");
				String name = scan.next();
				System.out.print("수정할 국어 입력 : ");
				int kor = scan.nextInt();
				System.out.print("수정할 영어 입력 : ");
				int eng  = scan.nextInt();
				System.out.print("수정할 수학 입력 : ");
				int math  = scan.nextInt();
				
				//수정
				sungJukDTOT.setName(name);
				sungJukDTOT.setKor(kor);
				sungJukDTOT.setEng(eng);
				sungJukDTOT.setMath(math);
				
				sungJukDTOT.calc();
				
				System.out.println("수정하였습니다.");
				break;
			}//if
		}//for
		if(!sw) System.out.println("잘못된 번호 입니다.");
	}
}
