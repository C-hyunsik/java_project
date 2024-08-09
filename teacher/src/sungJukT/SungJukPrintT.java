package sungJukT;

import java.util.ArrayList;


public class SungJukPrintT implements SungJukT{

	@Override
	public void execute(ArrayList<SungJukDTOT> list) {
		System.out.println();
		
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTOT sungJukDTOT : list) {
			System.out.println(sungJukDTOT);
		}//for
	}

}
