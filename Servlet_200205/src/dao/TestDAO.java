package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.JdbcUtil.*;

// DAO(Data Access Object)
public class TestDAO { 
	
	private static TestDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static TestDAO getInstance() {
		if (dao == null) {
			dao = new TestDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertName(String name) {
		String sql = "INSERT INTO NAMETEST VALUES(?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<String> selectDB() {
		String sql = "SELECT * FROM NAMETEST";
		List<String> nameList = new ArrayList<String>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				nameList.add(rs.getString("NAME1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return nameList;
	}
}

















