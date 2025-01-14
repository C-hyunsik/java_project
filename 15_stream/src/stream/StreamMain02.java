package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Food{
	String name;
	int calorie;
}

public class StreamMain02 {
	static int hap;
	public static void main(String[] args) {
		Food aa = new Food("탕수육", 616);
		Food bb = new Food("라면", 460);
		Food cc = new Food("돈까스", 960);
		Food dd = new Food("떡볶이", 482);
		Food ee = new Food("짜장면", 670);
		
		List<Food> list = new ArrayList<>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		list.add(dd);
		list.add(ee);
		
		List<Food> callist = new ArrayList<Food>();
		for(Food food : list) {
			if(food.getCalorie()>500) {
				callist.add(food);
			}
		}
		Comparator<Food> com = new Comparator<Food>() {
			
			@Override
			public int compare(Food f1, Food f2) {
				/*
				if(f1.getCalorie() < f2.getCalorie()) {
					return 1;	
				}
				else if(f1.getCalorie() > f2.getCalorie())
					return -1;
				else
					return 0;
				*/
				return Integer.compare(f1.getCalorie(), f2.getCalorie());
			}
		};
		Collections.sort(callist, com);
		List<String> foodName = new ArrayList<String>();
		for(Food food : callist) {	//외부반복
			foodName.add(food.getName());
		}
		System.out.println(foodName);
		System.out.println();
		
		//스트림이용
		List<String> foodNameList = list.stream()
										.filter(f -> f.getCalorie() > 500)
										.sorted(Comparator.comparing(Food :: getCalorie))
										.map(f -> f.getName())
										.collect(Collectors.toList());
		
		System.out.println(foodNameList);
		
		//합계
		// .reduce(초기값, (누적변수, 요소) -> 처리문)
		// .reduce()는 Stream의 요소들을 하나의 데이터로 만드는 작업을 수행
		IntStream stream = IntStream.range(1, 5);	//range() : 끝 수를 포함하지 않는다. 1,2,3,4
		int sum = stream.reduce(0, (total,num) -> total + num);
		System.out.println("합계 = " + sum);
		System.out.println();
		
		IntStream stream2 = IntStream.rangeClosed(1, 5);//rangeClosed() : 끝 수를 포함한다. 1,2,3,4,5
		stream2.forEach(x -> hap += x);
		System.out.println("합계 = " + hap);
		
	}

}
