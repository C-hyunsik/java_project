package board2.service;

import board2.bean.Board2DTO;
import board2.dao.Board2DAO;

public class Board2ListService implements Board2{

	@Override
	public void execute() {
		System.out.println("---------------------------------------------------------");
		System.out.println("글번호\t제목\t아이디\t날짜");
		System.out.println("---------------------------------------------------------");
		
		Board2DTO board2DTO = new Board2DTO();
		Board2DAO board2DAO = Board2DAO.getInstance();
		
		board2DAO.list(board2DTO);
	}

}
