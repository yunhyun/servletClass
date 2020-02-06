package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberViewService {

	public MemberDTO memberView(String id) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		MemberDTO viewMember = dao.memberView(id);
		
		close(con);
		return viewMember;
	}

}
