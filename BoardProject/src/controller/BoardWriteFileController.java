package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import service.BoardWriteService;

@WebServlet("/boardWriteFile")
public class BoardWriteFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteFileController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int size = 10*1024*1024;
		String savePath = "C:/Users/1/git/servletClass/servletClass/BoardProject/WebContent/fileUpload";

    	MultipartRequest multi = new MultipartRequest(
				request,
				savePath,
				size,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
    	
    	BoardDTO boardDTO = new BoardDTO();
    	
    	boardDTO.setbWriter(multi.getParameter("bWriter"));
		boardDTO.setbTitle(multi.getParameter("bTitle"));
		boardDTO.setbPassword(multi.getParameter("bPassword"));
		boardDTO.setbContents(multi.getParameter("bContents"));
		boardDTO.setbFile(multi.getOriginalFileName(
					(String)multi.getFileNames().nextElement()));
    	
    	BoardWriteService boardWriteService = new BoardWriteService();
    	int writeResult = boardWriteService.boardWriteFile(boardDTO);
		
    	if(writeResult > 0) {
    		response.sendRedirect("boardList");
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
