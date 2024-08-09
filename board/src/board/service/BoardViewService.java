package board.service;

import java.util.Scanner;

import board.dao.BoardDAO;

public class BoardViewService implements Board {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("조회할 글 번호를 입력하세요 : ");
		int seq = sc.nextInt();
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		boardDAO.view(seq);
		
	}

}
