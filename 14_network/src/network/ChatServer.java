package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {
	ServerSocket serverSocket;	//클라이언트의 연결 요청을 수락
	ExecutorService threadPool = Executors.newFixedThreadPool(100);	//100개의 클라이언트가 동시에 채팅가능
	Map<String, ChatHandler> chatRoom = Collections.synchronizedMap(new HashMap<>());
	//통신용 ChatHandler를 관리하는 동기화된 Map 컬렉션
	
	//서버 시작
	private void start() throws IOException {
		serverSocket = new ServerSocket(9500);
		System.out.println("서버 준비 완료");
		
		Thread thread = new Thread(() -> {
			try {
				while(true) {
					Socket socket = serverSocket.accept();	//연결 수락하고, 통신용 ChatHandler를 반복해서 생성
					ChatHandler chatHandler = new ChatHandler(this, socket);
					
				}
			} catch (IOException e) {
				//e.printStackTrace();
			}
			
		});	//Runnable를 람다식 제공
		
		thread.start();	//스레드 시작
		
	}//start()
	
	//클라이언트 연결 시 ChatHandler 생성 및 추가
	public void addSocketClient(ChatHandler chatHandler) {
		String key = chatHandler.chatName + "@" + chatHandler.clientIp;
		chatRoom.put(key, chatHandler);
		System.out.println("입장 : " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
	}
	//클라이언트 연결 종료 시 ChatHandler 제거
	public void removeSocketClient(ChatHandler chatHandler) {
		String key = chatHandler.chatName + "@" + chatHandler.clientIp;
		chatRoom.remove(key);
		System.out.println("퇴장 : " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
	}
	
	//모든 클라이언트에게 메세지 보냄
	public void sendToAll(ChatHandler sender, String msg) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("clientIP", sender.clientIp);
		jsonObject.put("chatName", sender.chatName);
		jsonObject.put("message", msg);
		
		String json = jsonObject.toString();	//jsonObject -> String 변환
		
		Collection<ChatHandler> collection = chatRoom.values();
		for(ChatHandler chatHandler : collection) {
			if(chatHandler == sender) continue;	//메세지를 보낸 ChatHandler는 제외
			chatHandler.send(json);
		}
	}
	//서버 종료
	private void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
			
			//chatRoom에 있는 모든 ChatHandler를 닫는다
			//chatRoom.values()로 Collection<ChatHandler>를 얻고, 요소 스트림을 이용해서 전체 ChatHandler의 close()를 호출
			chatRoom.values().stream().forEach(ch -> ch.close());
			
			System.out.println("서버 종료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//stop()
	
	public static void main(String[] args) {
		try {
		ChatServer chatServer = new ChatServer();
		chatServer.start();
		
		System.out.println();
		System.out.println("서버를 종료하려면  q를 입력하세요");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			String key = sc.nextLine();
			if(key.toLowerCase().equals("q")) break;
		}	
			sc.close();
			
			chatServer.stop();
			
		}catch(IOException e) {
			System.out.println("[서버] " + e.getMessage());
		}
		
	}

}
/*
JSON 데이터 형식
=> *.jar 필요
   https://mvnrepository.com/
   json-20231013.jar 
=> 네트워크로 전달하는 데이터가 복잡할수록 구조화된 형식이 필요하다.
   네트워크 통신에서 가장 많이 사용되는 데이터 형식은 JSON(JavaScript Object Notation)이다.
   
[형식]
① JSON 객체
{
	"속성명" : 값,
	"속성명" : 값
}   

② JSON 배열
[
	"문자열" or
	{ ......} or
	[ ......]
]
 */