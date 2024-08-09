package thread;

class Singleton {
	private int num = 3;
	private static Singleton instance;

	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				instance = new Singleton();
			}
		}
		return instance;
	}
	public void calc() {
		num++;
	}
	public void disp() {
		System.out.println("num = " + num);
	}
}
//----------------------------------------------
public class SingletonMain {

	public static void main(String[] args) {
		Singleton aa = Singleton.getInstance();

		aa.calc();
		aa.disp();
		System.out.println();

		Singleton bb = Singleton.getInstance();

		bb.calc();
		bb.disp();
		System.out.println();

		Singleton cc = Singleton.getInstance();

		cc.calc();
		cc.disp();
		System.out.println();

	}

}
