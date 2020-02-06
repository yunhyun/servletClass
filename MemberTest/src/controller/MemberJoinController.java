package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberJoinService;

@WebServlet("/memberJoin")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberJoinController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id, password, name, gender, email;
		String birth;
		id = request.getParameter("id");
		password = request.getParameter("password");
		name = request.getParameter("name");
		birth = request.getParameter("birth");
		gender = request.getParameter("gender");
		email = request.getParameter("email");
		
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(birth);
		member.setGender(gender);
		member.setEmail(email);
		
		MemberJoinService memberJoinService = new MemberJoinService();
		//memberJoinService.memberJoin(id, password, name, birth, gender, email);
		int result = memberJoinService.memberJoin(member);
		
		if(result>0) {
			response.sendRedirect("LoginForm.jsp");
		} else {
			response.sendRedirect("JoinFail.jsp");
		}
		
//		System.out.println(id);
//		System.out.println(password);
//		System.out.println(name);
//		System.out.println(birth);
//		System.out.println(gender);
//		System.out.println(email);
		
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
