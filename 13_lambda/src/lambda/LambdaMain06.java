package lambda;

@FunctionalInterface
interface Comp{
	public int compare(String name, String irum);	//음수, 0, 양수
}
//------------------------------------
class Person06{
	public void order(Comp comp) {
		String name = "홍길동";
		String irum = "코난";
		
		int result = comp.compare(name, irum);
		
		if(result < 0) {
			System.out.println(name + ", " + irum);		//내림차순
		}
		else if(result > 0) {
			System.out.println(irum + ", " + name);		//오름차순
		}
		else
			System.out.println("같은 이름입니다.");
	}
}

//------------------------------------
public class LambdaMain06 {

	public static void main(String[] args) {
		Person06 person06 = new Person06();
		
		person06.order((name, irum) -> name.compareTo(irum));		//String의 compareTo()
		
		person06.order(String :: compareTo);
		
	}

}
