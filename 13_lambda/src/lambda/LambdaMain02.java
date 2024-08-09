package lambda;

class Person02 {
	public void execute(Workable work) {
		work.work();
	}
}
//-------------------------------------------
public class LambdaMain02 {
	
	public static void main(String[] args) {
		Person02 person02 = new Person02();
		
		person02.execute(() -> {
			System.out.println("안녕하세요");
			System.out.println("아무거나입니다.");
		});
		//실행문이 1개일 경우에는 {} 생략가능
		person02.execute(() -> System.out.println("반갑습니다"));
	}

}
