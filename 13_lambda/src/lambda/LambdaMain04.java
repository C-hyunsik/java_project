package lambda;

class Person04{
	public void execute(Compute02 com) {
		String result = com.calc(25, 36);
		
		System.out.println(result);
	}
	public int mul(int x, int y) {
		return x * y;
	}
	public double div(double x, double y) {
		return x / y;
	}
}
//--------------------------------------------------
public class LambdaMain04 {
	
	public static void main(String[] args) {
		Person04 person04 = new Person04();
		
		person04.execute((x, y) -> {
			int result = x + y;
			return x + " + " + y + " = " + result;
		});
		//실행문이 1개일 경우에는 {}과 함께 return 생략 가능
		person04.execute((x, y) -> x + " + " + y + " = " + (x + y));
		
		person04.execute((x, y) -> x + " - " + y + " = " + (x - y));
		
		person04.execute((x, y) -> x + " * " + y + " = " + person04.mul(x,y));
		
		person04.execute((x, y) -> x + " / " + y + " = " + String.format("%.2f", person04.div(x,y)));
	}

}
