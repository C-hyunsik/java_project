package collection;

public class GenericMain2<T> {
	private T a;
	public GenericMain2(T a) {
		this.a = a;
	}
	public void setA(T a) {
		this.a = a;
	}
	
	public T getA() {
		return a;
	}
	
	public static void main(String[] args) {
		//GenericMain2<?> aa = new GenericMain2<String>();
		//aa.setA("홍길동");	-error 반드시 데이터는 setter가 아니라 생성자로 넣어야 한다.
		
		GenericMain2<?> aa = new GenericMain2<String>("홍길동");	//생성자로 데이터 입력
		String name = (String)aa.getA();		//Object형으로 들어왔기 때문에 형변환 필요
		System.out.println("이름 = " + name);
		
		GenericMain2<?> bb = new GenericMain2<Integer>(25);
		int age = (int)bb.getA();
		//class형(Integer)을 기본형(int)으로 unboxing
		System.out.println("나이 = " + age);
		
		

	}
}