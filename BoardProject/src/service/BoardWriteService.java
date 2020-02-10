package service;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardWriteService {

	public int boardWrite(BoardDTO boardDTO) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int writeResult = dao.boardWrite(boardDTO); 
		
		if(writeResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return writeResult;
	}

}
