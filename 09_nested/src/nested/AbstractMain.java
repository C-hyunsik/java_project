package nested;

public class AbstractMain {

	public static void main(String[] args) {
		
	//AbstractTest at = new AbstractTest();	-error
		//추상 메소드 있음 -> 반드시 추상 메소드를 Override(강제성)
	//AbstractExam ae = new AbstractExam();	-error 
		//추상 메소드 없음 -> 개발자가 원하는 메소드를 선택하여 Override
		
		//저장 시 AbstractMain$1.class 파일 생성
		AbstractTest at = new AbstractTest() {		//익명 Inner class를 new
			@Override
			public void setName(String name) {}		//구현
		};
		//저장 시 AbstractMain$2.class 파일 생성
		InterA in = new InterA() {		//익명 class를 new
			@Override
			public void aa() {}
			@Override
			public void bb() {}
		};
		AbstractExam ae = new AbstractExam() {
			//추상 메소드 없음 -> 개발자가 원하는 메소드만 Override
		};
	}
}
