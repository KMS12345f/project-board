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
import service.FreeBoardDAO;


@WebServlet("/Search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
		
		String Search = request.getParameter("search");
		String Value = request.getParameter("searchvalue");

		System.out.println("=========="+Search);
		System.out.println("=========="+Value);

		FreeBoardDAO dao = new FreeBoardDAO();
		
		List<FreeBoardDTO> list = dao.search(Search, Value);

		String page = "search.jsp";
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		  
		request.setAttribute("list", list);
		 
		dispatcher.forward(request, response);

	}


}
