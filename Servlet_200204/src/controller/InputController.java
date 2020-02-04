package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.InputService;

@WebServlet("/inputServer")
public class InputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InputController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// jsp 에서 받은 파라미터 값 가져오기 
		String data1, data2;
		data1 = request.getParameter("data1");
		data2 = request.getParameter("data2");
		System.out.println(data1);
		System.out.println(data2);
		
		// DB에 data1, data2 저장하기 
		// 저장하는 과정 : InputDB.jsp -> InputController -> InputService
		//				  -> DAO -> DB의 test 테이블  
		InputService inputService = new InputService();
		
		// inputService 클래스에 inputDB 메소드를 정의해서 data1, data2를 넘기세요.
		// 그리고 리턴 결과를 boolean 타입의 inputResult 변수에 담으세요. 
		boolean inputResult;
		inputResult = inputService.inputDB(data1, data2);
		
		// 페이지 전환 방식 
		/*
		 * 1. redirect 
		 *    - 지정된 페이지로 이동하지만 값을 가지고 갈 수는 없음
		 *    - 주소값이 지정된 페이지 또는 파일 명으로 바뀜
		 * 2. dispatch 
		 *    - 지정된 페이지로 이동하면서 값을 가지고 갈 수 있음. 
		 *    - 주소값이 바뀌지 않음. 
		 */
		// redirect 방식으로 RedirectResult.jsp 페이지로 이동  
//		response.sendRedirect("RedirectResult.jsp");
		// dispatch 방식으로 DispatchResult.jsp 페이지로 이동 
//		RequestDispatcher dispatcher = 
//				request.getRequestDispatcher("DispatchResult.jsp"); 
//		dispatcher.forward(request, response);
		
		/*
		영역객체(Scope)와 속성(Attribute)
		영역객체 종류 : page, request, session, application

		1. page : 해당 페이지가 유지되어 있는 동안에만 유효함. 
			페이지가 바뀌면 사라짐. 
		2. request : 클라이언트의 요청이 처리되는 동안에 유효. 
			포워딩을 수행해도 유지가 되기 때문에 request영역에 데이터를 
			저장하면 다양하게 활용할 수 있음. 
		3. session : 웹브라우저가 실행되고 있는 동안에 유효. 
			웹 브라우저를 닫기 전까지는 session영역에 담겨있는 데이터는 사라지지 
			않고 계속 유지할 수 있음. 
			웹사이트에서 로그인 했을 때 로그인 정보를 보통 session 영역에 담음. 
		4. application : 서버가 구동되고 있는 동안에 유효	. 
			서버를 올리고 나서 내리기 전까지는 application 영역에 담은 데이터는 
			계속 유지됨. 
		*/
		// request 영역에 데이터 저장해서 RedirectResult.jsp로 이동 
//		request.setAttribute("reqData1", "파라미터에 저장되는 값");
//		request.setAttribute("reqData2", "여기에도 저장 됩니다.");
//		request.setAttribute("reqData3", data1);
//		
//		// session 객체 생성 
//		HttpSession session = request.getSession();
//		// session 영역에 데이터 저장 
//		session.setAttribute("seData1", "세션에 저장되는 값");
//		session.setAttribute("seData2", "세션에 저장되는 값 두번째");
//		session.setAttribute("seData3", data2);
//		
////		response.sendRedirect("RedirectResult.jsp");
//		RequestDispatcher dispatcher = 
//				request.getRequestDispatcher("DispatchResult.jsp"); 
//		dispatcher.forward(request, response);
		
		/*
		 * DB 연동하기 
		 *  1. ojdbc6.jar 파일을 톰캣 설치 폴더의 lib 폴더에 복사하세요. 
		 *  2. DB 계정 생성 
		 *  3. META-INF 폴더에 context.xml 파일 생성 
		 *  4. JdbcUtil 클래스 생성 및 내용 작성
		 *  5. Service, DAO 클래스 생성 
		 *    - Service 클래스 : controller에서 넘겨받은 내용에 대한 처리 및
		 *     	DB 연동을 위한 DAO 클래스 호출 
		 *    - DAO 클래스 : DB와 CRUD 작업을 수행  
		 */
		
		
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
