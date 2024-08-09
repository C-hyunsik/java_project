package board.service;

import java.util.Scanner;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteService implements Board {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("제목 입력 : ");
		String subject = sc.next();
		sc.nextLine();
		System.out.print("내용 입력 : ");
		String content = sc.nextLine();
		
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		int su = boardDAO.write(boardDTO);
		System.out.println("작성하신 글을 등록하였습니다.");
	}

}
