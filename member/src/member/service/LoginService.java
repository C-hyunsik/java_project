package member.service;

import java.util.Scanner;

import member.dao.MemberDAO;

public class LoginService implements Member{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pw = sc.next();
		
		String name = memberDAO.login(id,pw);
		if(name == null) {
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		}
		else {
			System.out.println(name + "님 로그인");
		}
	}
}
