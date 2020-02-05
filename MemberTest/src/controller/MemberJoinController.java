package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberJoin")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberJoinController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id, pwd, name, birth, emailId, emailDomain, postcode, address, detailAddress, phone;
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		name = request.getParameter("name");
		birth = request.getParameter("birth");
		emailId = request.getParameter("emailId");
		emailDomain = request.getParameter("emailDomain");
		postcode = request.getParameter("postcode");
		address = request.getParameter("address");
		detailAddress = request.getParameter("detailAddress");
		phone = request.getParameter("phone");
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		System.out.println(birth);
		System.out.println(emailId);
		System.out.println(emailDomain);
		System.out.println(postcode);
		System.out.println(address);
		System.out.println(detailAddress);
		System.out.println(phone);
		
		
		
		
		
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
