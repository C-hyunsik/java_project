package sungJuk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {
	int kor, eng, math;
	String name, n;
	public SungJukDelete(ArrayList<SungJukDTO> list) {
		
	}

	
	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		Iterator<SungJukDTO> it = list.iterator();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		n = sc.next();
		
		int count =0;
		while(it.hasNext()) {
			SungJukDTO sungJukDTO = it.next();
			if(sungJukDTO.getName().equals(n)) {
				it.remove();
				count++;
			}
		}
	
		if(count == 0) {
			System.out.println("회원의 정보가 없습니다.");
			return;
		}
		else {
			System.out.println(count + "건의 항목을 삭제하였습니다.");
			
		}
	}
}
