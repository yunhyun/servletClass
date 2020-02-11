package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListService {

	public List<BoardDTO> boardList() {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<BoardDTO> boardList = dao.boardList();
		
		close(con);
		
		return boardList;
	}


}
