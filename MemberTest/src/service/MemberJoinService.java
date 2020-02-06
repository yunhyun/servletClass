package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberJoinService {

	public int memberJoin(MemberDTO member) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.memberJoin(member);
		
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}

}







