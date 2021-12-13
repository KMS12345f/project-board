package boardController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FreeBoardDAO;

@WebServlet("/boardInsert")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("text");
		String writer = request.getParameter("writer");
		
		FreeBoardDAO dao = new FreeBoardDAO();
		dao.insertBoard(title, content, writer);
		
		response.sendRedirect("BoardView");
	
	}


}
