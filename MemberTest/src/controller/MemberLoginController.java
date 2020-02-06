package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberLoginService;

@WebServlet("/memberLogin")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id, password;
		id = request.getParameter("id");
		password = request.getParameter("password");
		
		MemberLoginService memberLoginService = new MemberLoginService();
		
		String loginId = memberLoginService.memberLogin(id, password);
		
		// Session 객체 생성 
		HttpSession session = request.getSession();
		
		if(loginId!=null) {
			session.setAttribute("loginId", loginId);
			response.sendRedirect("MemberMain.jsp");
		} else {
			response.sendRedirect("LoginFail.jsp");
		}
				
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
