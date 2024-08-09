package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer {
	ServerSocket serverSocket;

	Socket socket;
	BufferedReader br;
	BufferedWriter bw;

	public ProtocolServer() {
		try {
			serverSocket = new ServerSocket(9800);	//클라이언트가 올 때까지 기다린다.
			System.out.println("서버 준비 완료..");

			socket = serverSocket.accept();	//클라이언트를 낚아채서 소켓을 생성함

			//io생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}
		//-------------------------
		String line;
		try {
			while(true) {
				//클라이언트로부터 받기
				line = br.readLine();

				String[] ar = line.split(":");

				//클라이언트로 보내기
				if(ar[0].equals(Protocol.ENTER)) {	//입장 => 100:대화명
					bw.write(ar[1] + "님 입장하였습니다.\n");
					bw.flush();
				}
				else if(ar[0].equals(Protocol.EXIT)) {	//퇴장 => 200:대화명
					bw.write(ar[1] + "님 퇴장하였습니다.\n");
					bw.flush();

					br.close();
					bw.close();
					socket.close();
					System.out.println("서버 종료");
					System.exit(0);
				}
				else if(ar[0].equals(Protocol.SEND_MESSAGE)) {	//메세지 => 300:대화명:메세지
					bw.write("[" + ar[1] + "] " + ar[2] + "\n");
					bw.flush();
				}
			}//while
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ProtocolServer();

	}

}
