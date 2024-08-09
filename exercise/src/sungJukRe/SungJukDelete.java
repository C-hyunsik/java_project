package sungJukRe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {
	SungJukDTO sungJukDTO = new SungJukDTO();
	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		Scanner sc = new Scanner(System.in);
		String name;
		
		System.out.println();
		System.out.print("삭제할 이름 입력 : ");
		name = sc.next();
		
		int count = 0;
		
		Iterator<SungJukDTO> it = list.iterator();
		while(it.hasNext()) {
			SungJukDTO sungJukDTO = it.next();
			
			if(sungJukDTO.getName().equals(name)) {
				it.remove();
				count++;
			}
		}//while
		if(count == 0) {
			System.out.println("일치하는 회원이 없습니다.");
		}
		else {
			System.out.println(count + "건의 항목을 삭제하였습니다.");
		}
		
	}

}
