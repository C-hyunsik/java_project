package board2.service;

import java.util.Scanner;

import board2.dao.Board2DAO;

public class Board2ViewService implements Board2{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("글 번호를 입력하세요 : ");
		int seq = sc.nextInt();
		
		Board2DAO board2DAO = Board2DAO.getInstance();
		
		board2DAO.view(seq);
		
	}

}
