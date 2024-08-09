package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		System.out.println("벡터 크기 = " + v.size());		//기본 크기 0
		System.out.println("벡터 용량 = " + v.capacity());	//기본 용량 10, 용량 부족시 증가량 10
		System.out.println();
		
		System.out.println("항목 추가");
		for(int i = 1; i <= 10; i++) {
			//i는 int형 Vector는 String형을 받기 때문에 i를 String으로 만들기 위해 ""추가
			v.add(i + "");
			System.out.print( v.get(i-1) + "  "); //index는 0부터 시작
		}
		System.out.println();
		System.out.println("벡터 크기 = " + v.size());		//크기 10
		System.out.println("벡터 용량 = " + v.capacity());	//용량 10, 용량 부족시 증가량 10
		System.out.println();
		
		System.out.println("항목 1개 추가");
		v.addElement(5 + "");	//중복 허용
		for(int i = 0; i < v.size(); i++) {
			System.out.print( v.get(i) + "  "); //index는 0부터 시작
		}
		System.out.println();
		System.out.println("벡터 크기 = " + v.size());		//크기 10
		System.out.println("벡터 용량 = " + v.capacity());	//용량 10, 용량 부족시 증가량 10
		System.out.println();
		
		System.out.println("항목 5를 삭제");
		//v.remove(5);		//index 5번이 삭제 = 항목 '6'삭제
		v.remove(5 + "");	//항목 5 삭제, 중복값 중 앞쪽 항목이 삭제 뒤쪽을 지우려면 index로 삭제
		System.out.println(v);		//주소값 출력. toString()을 변형시켜 배열처럼 출력
		System.out.println();
		
		System.out.println("Iterator를 이용한 항목 출력");
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "  ");
		}
		System.out.println();
	}
}