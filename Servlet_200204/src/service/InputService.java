package service;

import dao.DAO;
import static db.JdbcUtil.*;
import java.sql.*;

public class InputService {

	public boolean inputDB(String data1, String data2) {
		/*
		 * 1. DAO 클래스에 대한 객체를 getInstance() 메소드를 호출하여 받아옴. 
		 * 2. JdbcUtil로 부터 connection 객체를 받아옴. 
		 * 3. DAO 클래스에 접속 완료된 정보를 전달 
		 * 4. DAO 클래스의 insert 수행 메소드 호출하여 DB 연동 작업 수행 
		 */
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		boolean inputResult = false;
		
		int result = dao.inputDB(data1, data2);
		if(result > 0) {
			commit(con);
			inputResult = true;
		} else {
			rollback(con);
			inputResult = false;
		}
		
		return inputResult;
		
		// Controller 클래스에서 insert가 성공하면 InsertSuccess.jsp
		// 실패하면 InsertFail.jsp 페이지로 이동하도록 코드를 작성하세요. 
		
	}

}







