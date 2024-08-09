package sungJukRe;

public class SungJukMain {

	public static void main(String[] args) {
		SungJukService sungJukService = new SungJukService();
		
		sungJukService.menu();
		
		System.out.println("프로그램이 종료되었습니다.");
	}
}