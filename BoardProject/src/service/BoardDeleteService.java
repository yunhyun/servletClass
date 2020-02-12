package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.BoardDAO;

public class BoardDeleteService {

	public int boardDelete(int bNumber) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.boardDelete(bNumber);
		
		if(result > 0) 
			commit(con);
		else
			rollback(con);
		
		close(con);
		return result;
	}

}






