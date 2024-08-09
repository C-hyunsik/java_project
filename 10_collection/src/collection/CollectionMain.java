package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {
	
	@SuppressWarnings("all")		//모든 항목에 대한 경고를 무시
	public static void main(String[] args) {
		Collection coll = new ArrayList();	//대신 Override 하는 클래스
		
		coll.add("호랑이");
		coll.add("사자");
		coll.add("호랑이");	//중복 허용
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");
		
		Iterator it = coll.iterator();
		//it.next();		//현재 위치에 항목을 꺼내서 buffer에 기억을 시키고 다음 항목으로 이동한다.
		//it.hasNext();		//현재 위치에 항목이 있으면 True 없으면 false
		
		while(it.hasNext()){
			System.out.println(it.next());	//순서대로 항목을 꺼내서 출력 없으면 종료
		}
		System.out.println(coll);
	}

}
