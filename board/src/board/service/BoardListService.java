package board.service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListService implements Board {

	@Override
	public void execute() {
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = new BoardDTO();
		
		boardDAO.list(boardDTO);
	}

}
