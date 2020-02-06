package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberLoginService {

	public String memberLogin(String id, String password) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		String loginId = dao.memberLogin(id, password);
		
		close(con);
		
		return loginId;

	}

}









