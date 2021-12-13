package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;
import service.MemberDAO;


@WebServlet("/searchMember")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");

		MemberDAO dao = new MemberDAO();
		
		List<MemberDTO> list = dao.search(name);

		String page = "memberSearch.jsp";
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		  
		request.setAttribute("list", list);
		 
		dispatcher.forward(request, response);

	}


}
