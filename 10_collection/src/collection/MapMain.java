package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "백설공주");	//Value 중복 가능
		map.put("book301", "자스민");
		map.put("book101", "엄지공주");	//key 중복 가능. (단, 덮어쓰기)
		map.put("book401", "덕혜옹주");
		
		System.out.println(map.get("book101"));
		System.out.println(map.get("book301"));
		System.out.println(map.get("book501"));		//key에 해당하는 데이터가 없으면 null
		System.out.println();
		
		for(Map.Entry<String, String> data : map.entrySet()) {
			String key = data.getKey();
			String value = data.getValue();
			
			System.out.println("key : " + key + "\tValue = " + value);
		}
	}
}