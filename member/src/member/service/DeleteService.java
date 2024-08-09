package member.service;

import java.util.Scanner;

import member.dao.MemberDAO;

public class DeleteService implements Member{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		String id = null;
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		while(true){
			System.out.println();
			System.out.print("아이디 입력 : ");
			id = sc.next();
			
			boolean exist= memberDAO.isExistId(id);
			if(!exist) {
				System.out.println("존재하지 않는 아이디입니다.");
			}
			else break;
		}
		System.out.print("비밀번호 입력 : ");
		String pw = sc.next();
		
		boolean exist2 = memberDAO.deleteSearch(pw);
		
		if(!exist2) {
			System.out.println("비밀번호가 맞지 않습니다. ");
		}
		else {
			int su = memberDAO.delete(id,pw);
			System.out.println(su + "개의 행이 삭제되었습니다.");
		}
	}

}
/*
아이디 입력 : hong
비밀번호 입력 : 1234
비밀번호가 맞지 않습니다.

아이디 검색 : hong
비밀번호 입력 : 333

x개의 행이 삭제되었습니다.
*/