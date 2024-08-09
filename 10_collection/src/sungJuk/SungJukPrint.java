package sungJuk;

import java.util.ArrayList;



public class SungJukPrint implements SungJuk {
	public SungJukPrint(ArrayList<SungJukDTO> list) {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
	}

	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		for(SungJukDTO sungJukDTO : list) {
			System.out.println(sungJukDTO);
		}
		System.out.println("출력 성공");
	}
}