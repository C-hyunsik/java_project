package interface_;

public interface InterA {
	//interface에는 상수와 추상메소드만 존재
	
	public static final String NAME = "홍길동";	//상수
	int AGE = 25;	//public static final 생략	상수
	
	public abstract void aa();					//추상메소드
	public void bb();		//abstract 생략 가능	추상메소드
	
}
