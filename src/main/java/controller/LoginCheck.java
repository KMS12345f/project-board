package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDTO;
import service.MemberDAO;


@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String uId = request.getParameter("id");
		String uPwd = request.getParameter("pwd");
		String sessionName = (String) session.getAttribute("userId");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		String name = dao.loginCheck(uId, uPwd);
		String id = dao.loginId(uId, uPwd);
		List<MemberDTO> list = dao.selectOneMember(uId);	
		
		  String message2 = new String(); 

		  if(id.equals("")) {
			  out.println("<script>alert('아이디 비밀번호를 확인해주세요.');</script>");
			  out.println("<script>window.location.href='login.jsp';</script>");
		  }else if(id.equals("admin")) {
			  message2 = name +"님 환영합니다."; 

			  session.setAttribute("userId", id); 
			  session.setAttribute("message2", message2); 

			  response.sendRedirect("main.jsp");
		  }else {
			  message2 = name +"님 환영합니다."; 

			  session.setAttribute("userName", name);
			  session.setAttribute("userId", id);
			  session.setAttribute("message2", message2); 
			  
			  String page = "main.jsp";
				 
			  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				  
			  request.setAttribute("list", list);
				 
			  dispatcher.forward(request, response);
		  }
		  
		  
	}

}
