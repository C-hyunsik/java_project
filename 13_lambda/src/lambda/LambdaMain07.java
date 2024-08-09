package lambda;

@FunctionalInterface
interface Create01{
	public Person create(String name);
}
//--------------------------------------------
@FunctionalInterface
interface Create02{
	public Person create(String name, int age);
}
//--------------------------------------------
class Person{
	private String name;
	private int age;
	
	public Person(String name) {
		this.name = name;
		System.out.println("Person(String name) 생성자");
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person(String name, int age) 생성자");
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
//--------------------------------------------
class PersonTest{
	public Person getPerson01(Create01 create01) {
		String name = "none";
		Person person = new Person(name);
		return person;
	}
	
	public Person getPerson02(Create02 create02) {
		String name = "홍길동";
		int age = 25;
		Person person = new Person(name, age);
		return person;
	}
}
//--------------------------------------------
public class LambdaMain07 {

	public static void main(String[] args) {
		PersonTest personTest = new PersonTest();
		
		Person one =  personTest.getPerson01(Person :: new);
		System.out.println("이름 : " + one.getName());
		System.out.println("나이 : " + one.getAge());
		System.out.println();
		
		Person two =  personTest.getPerson02(Person :: new);
		System.out.println("이름 : " + two.getName());
		System.out.println("나이 : " + two.getAge());
		System.out.println();
	}

}
/*
생성자 참조
생성자를 참조한다는 것은 객체를 생성하는 것을 의미한다.
생성자 Overload 되어 여러 개가 있을 경우, 함수형 인터페이스의 추상메소드와 동일한 매개변수 타입과 개수를 가진 생성자를 찾아 실행한다.

(a, b) -> {
	return new 클래스(a, b);
}
=> 생성자 참조  클래스 :: new

 */