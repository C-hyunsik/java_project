package collection;

public class PersonDTO /*extends Object */ implements Comparable<PersonDTO> {
	
	private String name;
	private int age;
	
	public PersonDTO() {
		
	}
	
	public PersonDTO(String name, int age) {
		//super();			//다 있음		부모클래스 호출. 생략가능
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "이름 = " + name + "\t나이 = " + age;
	}

	@Override
	public int compareTo(PersonDTO p) {
		
		//나이로 오름차순
		if(this.age < p.age) return -1;
		
		else if(this.age > p.age) return 1;
		else return 0;
		
		//나이로 내림차순
		/*
		if(this.age < p.age) return 1;
		else if(this.age > p.age) return -1;
		else return 0;
		*/
		
		//이름으로 오름차순
		//return this.name.compareTo(p.name);		//str1.compareTo(str2) 문자열 비교 후 오름차순
		//이름으로 내림차순
		//return this.name.compareTo(p.name) * -1;	//str1.compareTo(str2) 문자열 비교 후 -1을 곱하여 내림차순
	}
}
