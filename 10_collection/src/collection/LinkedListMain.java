package collection;

import java.util.LinkedList;
import static java.lang.System.out;

public class LinkedListMain {

	public static void main(String[] args) {
		String[] item = {"소나타", "렉스톤", "재규어"};
		
		LinkedList<String> q = new LinkedList<String>();
		
		for(String n : item)
			q.offer(n);		//요소 추가
		
		out.println("q의 크기 : " + q.size() + "\n");		//item배열의 크기 출력
		String data = "";
		
		while( (data = q.poll()) != null) {				//q 안에서 데이터를 꺼내서 data에 넣고 null인지 비교
			out.println(data + " 삭제");					//꺼낸 데이터를 삭제
			out.println("q의 크기 = : "+ q.size() + "\n");	//size 출력
		}
	}

}
