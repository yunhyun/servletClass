package dao;

import java.sql.*;
import java.util.*;

import static db.JdbcUtil.*;
import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int memberJoin(MemberDTO member) {
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
//			pstmt.setDate(4, member.getBirth());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public String memberLogin(String id, String password) {
		String sql = "SELECT ID FROM MEMBER WHERE ID=? AND PASSWORD=?";
		String loginId = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginId = rs.getString("ID");
			} else {
				loginId = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginId;
	}

	public List<MemberDTO> memberList() {
		String sql = "SELECT * FROM MEMBER";
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO();
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setName(rs.getString("NAME"));
//				member.setBirth(rs.getDate("BIRTH"));
				member.setBirth(rs.getString("BIRTH"));
				member.setGender(rs.getString("GENDER"));
				member.setEmail(rs.getString("EMAIL"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberList;
	}

	public MemberDTO memberView(String id) {
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		MemberDTO memberView = new MemberDTO();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberView.setId(rs.getString("ID"));
				memberView.setPassword(rs.getString("PASSWORD"));
				memberView.setName(rs.getString("NAME"));
				memberView.setBirth(rs.getString("BIRTH"));
				memberView.setGender(rs.getString("GENDER"));
				memberView.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberView;
	}
}














