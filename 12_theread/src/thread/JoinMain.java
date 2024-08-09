package thread;


class JoinTest implements Runnable{

	@Override
	public void run() {		//Call-Back 메소드
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);	//단위는 1/1000초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
	}
}
//-----------------------------------------------------------------------------
public class JoinMain {

	public static void main(String[] args) {
		JoinTest joinTest = new JoinTest();		//스레드 아님 -> 틀만 가져온 가짜
		Thread t = new Thread(joinTest);		//스레드 생성
		
		System.out.println("스레드 시작");
		t.start();								//스레드 시작
		try {
			t.join();							//스레드 우선순위
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("스레드 종료");			//join이 없다면 main먼저 처리 후 스레드 처리

	}

}

//메인이 끝나도 스레드는 종료되지 않는다.
//메인이 끝나도 백그라운드에서 스레드는 돌아간다.