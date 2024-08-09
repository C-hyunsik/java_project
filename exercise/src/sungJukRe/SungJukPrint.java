package sungJukRe;

import java.util.ArrayList;

public class SungJukPrint implements SungJuk {

	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		System.out.println();
		
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO sungJukDTO : list) {
			System.out.println(sungJukDTO);
		}
	}

}
