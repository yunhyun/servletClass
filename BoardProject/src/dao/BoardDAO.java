package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int boardWrite(BoardDTO boardDTO) {
		String sql = "INSERT INTO BOARD VALUES(BOARDNUM_SEQ.NEXTVAL, ?,?,?,?,SYSDATE, 0)";
		int writeResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getbWriter());
			pstmt.setString(2, boardDTO.getbPassword());
			pstmt.setString(3, boardDTO.getbTitle());
			pstmt.setString(4, boardDTO.getbContents());
			writeResult = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return writeResult;
	}

	public int listCount() {
		int listCount = 0;

		String sql = "SELECT COUNT(*) FROM BOARD";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("글 갯수 오류 : " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<BoardDTO> getBoardList(int startRow, int endRow) {
		System.out.println("startRow" + startRow);
		System.out.println("endRow" + endRow);
		String sql = "SELECT * FROM BOARDLIST WHERE BOARDLIST.RN BETWEEN ? AND ?";
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO boardDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					boardDTO = new BoardDTO();
					boardDTO.setbNumber(rs.getInt("BNUMBER"));
					boardDTO.setbWriter(rs.getString("BWRITER"));
					boardDTO.setbPassword(rs.getString("BPASSWORD"));
					boardDTO.setbTitle(rs.getString("BTITLE"));
					boardDTO.setbContents(rs.getString("BCONTENTS"));
					boardDTO.setbDate(rs.getDate("BDATE"));
					boardDTO.setbHits(rs.getInt("BHITS"));
					boardList.add(boardDTO);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return boardList;
	}

	public List<BoardDTO> boardList() {
		System.out.println("DAO boardList 메소드 호출");
		String sql = "SELECT * FROM BOARD";
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO boardDTO = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setbNumber(rs.getInt("BNUMBER"));
				boardDTO.setbWriter(rs.getString("BWRITER"));
				boardDTO.setbPassword(rs.getString("BPASSWORD"));
				boardDTO.setbTitle(rs.getString("BTITLE"));
				boardDTO.setbContents(rs.getString("BCONTENTS"));
				boardDTO.setbDate(rs.getDate("BDATE"));
				boardDTO.setbHits(rs.getInt("BHITS"));
				boardList.add(boardDTO);
			}
			
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("boardList 오류!!" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}

	public int boardHits(int bNumber) {
		String sql = "UPDATE BOARD SET BHITS=BHITS+1 WHERE BNUMBER=?";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public BoardDTO boardView(int bNumber) {
		String sql = "SELECT * FROM BOARD WHERE BNUMBER=?";
		BoardDTO boardDTO = new BoardDTO();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardDTO.setbNumber(rs.getInt("BNUMBER"));
				boardDTO.setbWriter(rs.getString("BWRITER"));
				boardDTO.setbPassword(rs.getString("BPASSWORD"));
				boardDTO.setbTitle(rs.getString("BTITLE"));
				boardDTO.setbContents(rs.getString("BCONTENTS"));
				boardDTO.setbDate(rs.getDate("BDATE"));
				boardDTO.setbHits(rs.getInt("BHITS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardDTO;
	}
}













