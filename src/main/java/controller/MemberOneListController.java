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

@WebServlet("/oneList")
public class MemberOneListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		
		List<MemberDTO> list = dao.selectOneMember(uId);

		String page = "memberOneList.jsp";
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		  
		request.setAttribute("list", list);
		 
		dispatcher.forward(request, response);

	}



}