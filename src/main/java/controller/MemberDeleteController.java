package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberDAO;

@WebServlet("/deleteProcess")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String uId = request.getParameter("id");
		String sessionName = (String) session.getAttribute("userId");
		
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     PrintWriter out = response.getWriter();
		 MemberDAO dao = new MemberDAO();
		 
		 
	     if(sessionName.equals("admin")){
			  System.out.println("==========작동");
			  dao.deletMember(uId);
			  response.sendRedirect("list");
		  }else {
			  System.out.println("==========작동");
			  dao.deletMember(uId);
			  session.invalidate();
			  response.sendRedirect("main.jsp");
		  }	
	
	}


}