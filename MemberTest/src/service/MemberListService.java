package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberListService {

	public List<MemberDTO> memberList() {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		memberList = dao.memberList();
		
		close(con);
		
		return memberList;
		
	}

}







