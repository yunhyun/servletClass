package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberModifyService {

	public MemberDTO memberModify(String id) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		MemberDTO memberModify = dao.memberView(id);
		
		close(con);
		
		return memberModify;
	}

}
