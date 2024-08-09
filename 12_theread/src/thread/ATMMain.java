package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ATM implements Runnable{
	private long depositMoney = 100000;		//잔액
	private long balance;					//찾을 금액
	private int count = 0;

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 " + Thread.currentThread().getName() + "고객님");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("현재 금액 : " + depositMoney);
			System.out.print("찾을 금액 : ");
			balance = Long.parseLong(br.readLine());
			//System.out.println("남은 금액 : " + (depositMoney - balance));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		withDraw();
	}
	public void withDraw() {
		if(depositMoney >= balance) {
			if(balance % 10000 == 0) {
				depositMoney -= balance;
				System.out.println("잔액은 : " + depositMoney + "입니다.");
			}
			else
				System.out.println("만원 단위로 입력하세요");				
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
	}

}

//-----------------------------------------------------
public class ATMMain {

	public static void main(String[] args) {
		ATM atm = new ATM();
		//스레드 생성
		Thread mom = new Thread(atm);		//같은 atm에 접근
		Thread son = new Thread(atm,"아들");		//같은 atm에 접근	스레드 이름 지정

		mom.setName("엄마");	//스레드 이름 지정

		mom.start();	//스레드 시작 -> 스레드 실행(run());
		son.start();


	}

}
