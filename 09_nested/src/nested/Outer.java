package nested;

public class Outer {
	private String name;
	
	public void output() {
		System.out.println("이름 = " + this.name + "\t나이 = "+ new Inner().age);
	}
	class Inner{
		private int age;
		public void disp() {
			System.out.println("이름 = " + Outer.this.name + "\t나이 = "+ this.age);
		}
		
	}//class inner
	
	public static void main(String[] args) {
		Outer out = new Outer();
		out.name = "홍길동";
		out.output();
		System.out.println();
		
		Outer.Inner in = out.new Inner();
		in.age = 25;
		in.disp();
		System.out.println();
		
		Outer.Inner in2 = out.new Inner();
		in2.age = 30;
		in2.disp();
		System.out.println();
		
		Outer.Inner in3 = new Outer().new Inner();
		//in3.name = "코난";		-error
		in3.age = 40;
		in3.disp();
		System.out.println();
	}

}//class Outer
