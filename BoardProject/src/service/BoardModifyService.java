package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardModifyService {

	public int boardModify(BoardDTO boardModify) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.boardModify(boardModify);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		
		return result;
	}

}











