package member.service;

import java.util.Scanner;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class WriteService implements Member{
	private String id = "";
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		//DB	-	싱글톤 : 메모리에 한번만 잡음
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = new MemberDTO();
		
		while(true){
			System.out.println();
			System.out.print("아이디 입력 : ");
			id = sc.next();
			
			boolean exist= memberDAO.isExistId(id);
			if(exist) {
				System.out.println("이미 사용중인 아이디입니다.");
			}
			else {
				System.out.println("사용가능한 아이디입니다.");
				break;
			}
		}
		//중복체크
		//isExistId 메소드 만들기
		//리턴된 값이 true 이면 "사용중인 아이디입니다."라고 출력하고 다시 입력 받는다.
		//		   false이면 "사용가능한 아이디" 라고 출력하고 비밀번호를 입력받으러 간다.
		
		System.out.print("비밀번호 입력 : ");
		String pw = sc.next();
		System.out.print("핸드폰 입력(010-1234-1234) : ");
		String phone = sc.next();
		
		
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setPhone(phone);
		
		
		
		
		//입력
		int su = memberDAO.write(memberDTO);
		
		System.out.println(su + "개의 행이 만들어졌습니다.");
	}
/*
	public boolean isExistId() {
		
		System.out.print("아이디 입력 : ");
		id = sc.next();
		if(memberDTO.getId().equals(id)) {
			return true;
		}
		return false;
	}
*/
}
