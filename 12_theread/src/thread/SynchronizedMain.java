package thread;

class Synchronized extends Thread {
	private static int count;
	
	@Override
	public void run() {
		synchronized (Synchronized.class) {
			
			for(int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + " : " + count);
			}
		}
	}
		
}

//----------------------------------

public class SynchronizedMain {

	public static void main(String[] args) {
		Synchronized aa = new Synchronized();	//스레드 생성(상속)
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();
		
		aa.setName("A");
		bb.setName("B");
		cc.setName("C");
		
		//우선순위
		//1 ~ 10	숫자가 높을수록 우선순위가 높다
		aa.setPriority(Thread.MIN_PRIORITY);	//aa.setPriority(1);	가장 낮은 우선순위
		bb.setPriority(Thread.MAX_PRIORITY);	//bb.setPriority(10);	가장 높은 우선순위
		cc.setPriority(Thread.NORM_PRIORITY);	//cc.setPriority(5);	중간 우선순위
		
		aa.start();		//스레드 시작 -> 스레드 실행(run())
		bb.start();
		cc.start();
		
	}

}
