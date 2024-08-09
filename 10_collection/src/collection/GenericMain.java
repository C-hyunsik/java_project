package collection;

public class GenericMain<T> {
	private T a;
	
	public void setA(T a) {
		this.a = a;
	}
	
	public T getA() {
		return a;
	}
	
	public static void main(String[] args) {
		GenericMain<String> aa = new GenericMain</*String*/>();
		aa.setA("홍길동");
		System.out.println("이름 = " + aa.getA());
		//aa.setA(25);	-error Generic을 String 타입으로 잡았기 때문에 문자열만 입력 가능
		GenericMain<Integer> bb = new GenericMain</*Integer*/>();
		bb.setA(25);
		System.out.println("나이 = " + bb.getA());
		

	}

}
