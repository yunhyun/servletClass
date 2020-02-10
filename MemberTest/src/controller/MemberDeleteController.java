package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberDeleteService;

@WebServlet("/memberDelete")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDeleteController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String deleteId = request.getParameter("id");
		
		MemberDeleteService memberDeleteService = new MemberDeleteService();
		
		int deleteResult = memberDeleteService.memberDelete(deleteId);
		
		if(deleteResult > 0) {
			response.sendRedirect("memberList");
		} else {
			response.sendRedirect("DeleteFail.jsp");
		}
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
