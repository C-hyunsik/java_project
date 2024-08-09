package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ProtocolClient {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	Scanner sc;

	public ProtocolClient() {
		try {
			socket = new Socket("localhost", 9800);

			//io생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			sc = new Scanner(System.in);

		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}
		//----------------------
		String msg, line;
		try {
			while(true) {
				//서버로 보내기
				System.out.println();
				System.out.println("입장은 100:대화명 이라고 입력하세요");
				System.out.println("퇴장은 200:대화명 이라고 입력하세요");
				System.out.println("메세지는 300:대화명:메세지 이라고 입력하세요\n");
				
				msg = sc.nextLine();
				
				bw.write(msg + "\n");
				bw.flush();
				//서버에서 받기
				line = br.readLine();
				System.out.println(line);
				//200:apple -> "200", "apple"
				String[] ar = msg.split(":");
				
				//if(ar[0].equals("200")) {			//서버종료
				if(ar[0].equals(Protocol.EXIT)){	//서버종료
					br.close();
					bw.close();
					socket.close();
					
					System.out.println("클라이언트 종료");
					System.exit(0);
					
					
				}
			} 
		}//while
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//ProtocolClient()

	public static void main(String[] args) {
		new ProtocolClient();
	}

}
