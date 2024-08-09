package member.service;

import java.util.Scanner;

import member.dao.MemberDAO;
public class UpdateService implements Member{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		
		String id1 = memberDAO.search(id);
		if(id1 != null) {
			System.out.println("수정할 이름 입력 : ");
			String name = sc.next();
			System.out.println("수정할 비밀번호 입력 : ");
			String pw = sc.next();
			 
			int su = memberDAO.update(name,pw, id1);
			
			System.out.println(su + "개의 행을 수정하였습니다.");
		}
		else {
			System.out.println("검색한 아이디가 없습니다.");
		}
	}
}
/*
아이디 검색 : 
검색한 아이디가 없습니다.

아이디 검색 : hong
정보 출력
수정할 이름 입력 :
수정할 비밀번호 입력 : 

1개의 행을 수정하였습니다.
*/