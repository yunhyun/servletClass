package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dao.DAO;

public class SelectService {
	
	public List<String> selectDB() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<String> resultList = new ArrayList<String>();
		// DAO의 selectDB 메소드 호출하여 호출결과를 List에 담음. 
		resultList = dao.selectDB();
		
		close(con);
		
		return resultList;
		
	}
}










