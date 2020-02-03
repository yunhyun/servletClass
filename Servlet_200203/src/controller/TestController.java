package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inputTest")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
    	System.out.println("doProcess 메소드 호출");
		//jsp 에서 전달 받은 값을 콘솔 창에 출력 
		String value1, value2;
		//val1에 담긴 값을 value1에 저장 
		value1 = request.getParameter("val1");
		System.out.println("val1에 입력한 값: "+value1);
		value2 = request.getParameter("val2");
		System.out.println("val2에 입력한 값: "+value2);
		
		// 입력값을 숫자로 받아올 경우 
		int number1;
		number1 = Integer.parseInt(request.getParameter("num1"));
		System.out.println("num1에 입력한 값: "+number1);
		
		response.sendRedirect("RedirectPage.jsp");
		
		
		
		
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메소드 호출");
		doProcess(request, response);
	}

}






