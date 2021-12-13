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

@WebServlet("/BoardOneView")
public class BoardOneView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fNum = request.getParameter("fnum");
		int count = Integer.parseInt(request.getParameter("viewCount"));
		int fCount = count+1;
		
		FreeBoardDAO dao = new FreeBoardDAO();
		
		List<FreeBoardDTO> list = dao.selectOneView(fNum, fCount);
		
		String page = "oneView.jsp";
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		  
		request.setAttribute("list", list);
		 
		dispatcher.forward(request, response);

	}

}
