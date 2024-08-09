package member.main;

import java.util.Scanner;

import member.service.DeleteService;
import member.service.LoginService;
import member.service.Member;
import member.service.UpdateService;
import member.service.WriteService;

public class IndexMain {

	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int num;
		Member member = null;
		
		while(true) {
			System.out.println();
			System.out.println("*********************");
			System.out.println("   1.회원가입");
			System.out.println("   2.로그인");
			System.out.println("   3.회원정보수정");
			System.out.println("   4.회원탈퇴");
			System.out.println("   5.끝");
			System.out.println("*********************");
			
			System.out.print("   번호 : ");
			num = sc.nextInt();
			
			if(num == 5) break;
			else if(num == 1) {
				member = new WriteService();
				member.execute();
			}
			else if(num == 2) {
				member = new LoginService();
				member.execute();
			}
			else if(num == 3) {
				member = new UpdateService();
				member.execute();
			}
			else if(num == 4) {
				member = new DeleteService();
				member.execute();
			}
			else {
				System.out.println("1 ~ 5 중에서 입력하세요.");
				continue;
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		IndexMain indexMain = new IndexMain();
		
		indexMain.menu();
		System.out.println("프로그램을 종료합니다.");

	}

}
/*
데이터 : 이름(name), 아이디(id), 비밀번호(pw), 핸드폰(phone)

테이블 : member
컬럼  : 이름, 15자리
컬럼  : 아이디, 30자리
컬럼  : 비밀번호, 50자리
컬럼  : 핸드폰, 20자리
*/