package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress naver = new InetAddress();		//기본생성자 없음
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println("Naver IP = " + naver.getHostAddress());
		System.out.println();
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("Localhost = " + local.getHostAddress());
		System.out.println();
		
		InetAddress[] ar = InetAddress.getAllByName("www.naver.com");
		for(InetAddress data : ar) {
			System.out.println("Naver IP = " + data.getHostAddress());
		}
		InetAddress[] ar2 = InetAddress.getAllByName("www.nexon.com");
		for(InetAddress data : ar2) {
			System.out.println("Nexon IP = " + data.getHostAddress());
		}
	}

}
