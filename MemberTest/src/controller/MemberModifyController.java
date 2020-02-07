package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.MemberModifyService;

@WebServlet("/memberModify")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberModifyController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginId");
		
		MemberModifyService memberModifyService = new MemberModifyService();
		
		MemberDTO memberModify = memberModifyService.memberModify(id);
		
		request.setAttribute("memberModify", memberModify);
		RequestDispatcher dispatcher = 
    			request.getRequestDispatcher("MemberModify.jsp");
    	dispatcher.forward(request, response);
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
