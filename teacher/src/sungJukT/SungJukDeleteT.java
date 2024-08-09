package sungJukT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukDeleteT implements SungJukT{

	@Override
	public void execute(ArrayList<SungJukDTOT> list) {
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 이름 입력 : ");
		String name = sc.next();
		
		int count = 0;
		
		/*	-error	: 항목이 삭제되어 list 의 사이즈가 바뀐 것을 인식하지 못함.
		for(SungJukDTOT sungJukDTOT : list) {
			if(sungJukDTOT.getName().equals(name)) {
				list.remove(sungJukDTOT);
				count++;
			}
		}//for
		*/
		
		Iterator<SungJukDTOT> it = list.iterator();			//iterator 생성
		while(it.hasNext())	{					//현재 위치에 항목이 있으면 true 없으면 false
			SungJukDTOT sungJukDTOT = it.next();
			
			if(sungJukDTOT.getName().equals(name)) {
				it.remove();
				count++;
			}
		}//while
		
		if(count == 0)
			System.out.println("회원의 정보가 없습니다.");
		else
			System.out.println(count + "건의 항목을 삭제하였습니다.");
		
	}

}
