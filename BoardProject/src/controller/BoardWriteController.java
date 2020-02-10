package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardWriteService;

@WebServlet("/boardWrite")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
    	String bWriter = request.getParameter("bWriter");
    	String bPassword = request.getParameter("bPassword");
    	String bTitle = request.getParameter("bTitle");
    	String bContents = request.getParameter("bContents");
    	
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setbWriter(bWriter);
    	boardDTO.setbPassword(bPassword);
    	boardDTO.setbTitle(bTitle);
    	boardDTO.setbContents(bContents);
    	
    	BoardWriteService boardWriteService = new BoardWriteService();
    	int writeResult = boardWriteService.boardWrite(boardDTO);
		
    	if(writeResult > 0) {
    		response.sendRedirect("boardList");
//    		response.sendRedirect("boardListPaging");
    	} else {
    		response.sendRedirect("WriteFail.jsp");
    	}
		
    	
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
