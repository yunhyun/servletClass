package service;

import java.util.*;

import dao.BoardDAO;

import java.sql.*;
import static db.JdbcUtil.*;

import dto.BoardDTO;

public class BoardListPagingService {

	public int listCount() {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		int listCount = dao.listCount();
		close(con);
		
		return listCount;
	}

	public List<BoardDTO> boardList(int startRow, int endRow) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		List<BoardDTO> boardList = 
				dao.getBoardList(startRow, endRow);
		close(con);
		return boardList;
	}

}
