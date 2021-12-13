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

@WebServlet("/updateProcess")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uID = request.getParameter("id");
		String uName = request.getParameter("name");
		String uPhone = request.getParameter("phone1") + "-" + request.getParameter("phone2") + "-" + request.getParameter("phone3");
		String uEmail = request.getParameter("email");
		
		MemberDAO dao = new MemberDAO();
		
		String id = dao.updateMember(uName, uPhone, uEmail, uID);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("oneList");
		  
		request.setAttribute("uid", id);
		 
		System.out.println(id);
		dispatcher.forward(request, response);
	}
	
}