package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends Frame implements Runnable{		//프레임 창 호출 클래스 상속

	public Clock() {
		//setSize(300,400);		//창 크기 설정
		setVisible(true);		//창 보이기
		setFont(new Font("궁서",Font.BOLD,30));
		setBounds(800,400,300,400);
		setBackground(new Color(255,255,0));
		setForeground(Color.BLUE);
		Thread t = new Thread(this);//스레드 생성
		t.start();

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);	//강제종료
			}
		});
	}
	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while
	}
	//Call-Back 메소드
	//Frame에 그려준다
	@Override
	public void paint(Graphics g) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		Date date = new Date();


		g.drawString(sdf.format(date), 75, 200);

	}
	public static void main(String[] args) {
		new Clock();	//Frame이 생성되고, paint() 호출 -> 딱 1번

	}

}
