package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class URL2Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		URL url = new URL("http://www.goldria.net/m/product_list.html?xcode=012");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
	}
}
