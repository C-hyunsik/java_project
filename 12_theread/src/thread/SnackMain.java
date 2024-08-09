package thread;

public class SnackMain extends Thread {
	private String str;
	public SnackMain(String str) {
		this.str = str;
	}
	
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(str + "\ti=" + i + "\t" + Thread.currentThread() );
		}
	}
	public static void main(String[] args) {
		SnackMain aa = new SnackMain("새우깡");	//스레드 생성
		SnackMain bb = new SnackMain("포카칩");	//스레드 생성
		SnackMain cc = new SnackMain("수미칩");	//스레드 생성
		
		aa.setName("새우깡");
		bb.setName("포카칩");
		cc.setName("수미칩");
		
		aa.start();	//스레드 시작 -> 운영체제가 알아서 스레드 실행(운영체제가 알아서 run() 호출, 콜백메소드(Call Back))
		
		try {
		aa.join();		//스레드 우선순위 -> aa인 새우깡이 1순위로 실행
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		bb.start();
		cc.start();
		
		//aa.run();
		//bb.run();
		//cc.run();

	}

}
