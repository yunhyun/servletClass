package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberModifyProcessService;

@WebServlet("/memberModifyProcess")
public class MemberModifyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberModifyProcess() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberDTO member = new MemberDTO();
		
		member.setId(id);
		member.setName(name);
		member.setEmail(email);
		
		MemberModifyProcessService memberModifyProcessService = new MemberModifyProcessService();
		
		int modifyResult = memberModifyProcessService.memberModify(member);
		
		if(modifyResult > 0) {
			response.sendRedirect("MemberMain.jsp");
		} else {
			response.sendRedirect("ModifyFail.jsp");
		}
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}










