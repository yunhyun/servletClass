package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.MemberDAO;

public class MemberDeleteService {

	public int memberDelete(String deleteId) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int deleteResult = dao.memberDelete(deleteId);
		
		if(deleteResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return deleteResult;
	}

}






