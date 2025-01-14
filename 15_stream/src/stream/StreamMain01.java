package stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("이제훈");
		list.add("엄태구");
		list.add("이동욱");
		list.add("안효섭");
		list.add("이준기");
		list.add("나인우");
		
		System.out.println("for문으로 출력");
		for(int i = 0; i < list.size(); i++) {	//외부반복
			System.out.println(list.get(i));
		}
		System.out.println();
		
		System.out.println("Iterator로 출력");
		Iterator<String> it = list.iterator();	//외부반복
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		System.out.println("Stream, 람다식으로 출력");
		Stream<String> stream = list.stream();	//Collection 안에서 반복 -> 내부반복 : 속도적으로 이득
		//stream.forEach(name -> System.out.println(name));	//람다식으로 활용
		//System.out.println();
		
		stream.forEach(System.out :: println);
	}
	

}
