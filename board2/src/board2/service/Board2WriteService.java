package board2.service;

import java.util.Scanner;

import board2.dao.Board2DAO;

public class Board2WriteService implements Board2{
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		
		Board2DAO board2DAO = Board2DAO.getInstance();
		
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("제목 입력 : ");
		String subject = sc.next();
		sc.nextLine();
		System.out.print("내용 입력 : ");
		String content = sc.nextLine();
		
		board2DAO.write(id,name,subject,content);
		System.out.println("작성하신 글을 등록하였습니다.");
		
	}

}
