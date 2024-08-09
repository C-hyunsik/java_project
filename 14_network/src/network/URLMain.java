package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("프로토콜 = " + url.getProtocol());
		System.out.println("호스트 = " + url.getHost());
		System.out.println("포트 = " + url.getPort());
		System.out.println("기본 포트 = " + url.getDefaultPort());
		System.out.println("파일 = " + url.getFile());
		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		
		while( (line = br.readLine()) != null) {	//null값이 아닐때까지 한 줄씩 읽음 
			System.out.println(line);
		}
		br.close();
	}
}
