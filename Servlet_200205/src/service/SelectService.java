package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.TestDAO;

public class SelectService {

	public List<String> selectDB() {
		TestDAO dao = TestDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<String> nameList = new ArrayList<String>();
		nameList = dao.selectDB();
		
		close(con);
		return nameList;
	}

}








