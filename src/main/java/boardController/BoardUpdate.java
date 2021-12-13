package boardController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FreeBoardDAO;

@WebServlet("/BoardUpdate")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("fnum");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		FreeBoardDAO dao = new FreeBoardDAO();
		
		String fNum = dao.updateBoard(num, title, content);
		
		System.out.println("==========="+fNum);

		response.sendRedirect("BoardView");
		
	}

}