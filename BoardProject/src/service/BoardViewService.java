package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardViewService {

	public BoardDTO boardView(int bNumber) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		// 1. 조회수 컬럼 1증가 2. 해당 글 내용 가져오기 
		int bHits = dao.boardHits(bNumber);
		
		if(bHits > 0)
			commit(con);
		else
			rollback(con);
		
		BoardDTO boardView = dao.boardView(bNumber);
		
		close(con);
		return boardView;
		
		
		
	}

}




