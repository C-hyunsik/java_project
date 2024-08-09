package lambda;

public class LambdaMain01 {
	
	public void execute(Compute com) {	//구현
			int x = 25;
			int y = 36;
			
			com.calc(x, y);		//호출
	}

	public static void main(String[] args) {
		LambdaMain01 lambdaMain01 = new LambdaMain01();
		
		lambdaMain01.execute((x,y) -> {		//람다식
			int result = x + y;
			System.out.println(x + " + " + y+" = " + result);
		});
		lambdaMain01.execute((x,y) -> {
			int result = x * y;
			System.out.println(x + " x " + y+" = " + result);
		});
	}

}
