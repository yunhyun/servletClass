package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.TestDAO;

public class TestService {

	public int insertName(String name) {
		TestDAO dao = TestDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result;
		result = dao.insertName(name);
		
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
