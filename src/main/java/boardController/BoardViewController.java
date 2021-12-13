package boardController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreeBoardDTO;
import model.MemberDTO;
import service.FreeBoardDAO;
import service.MemberDAO;


@WebServlet("/BoardView")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDAO dao = new FreeBoardDAO();
		
		List<FreeBoardDTO> list = dao.selectAllFree();
		
		String page = "list.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		
		request.setAttribute("list", list);
		
		dispatcher.forward(request, response);
		
	}

}
