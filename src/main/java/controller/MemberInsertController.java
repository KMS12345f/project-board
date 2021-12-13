package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;
import service.MemberDAO;

@WebServlet("/memberProcess")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone1") + "-" + request.getParameter("phone2")+ "-" +request.getParameter("phone3");
			String birth = request.getParameter("birth");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			
			MemberDAO dao = new MemberDAO();
			
			dao.insertMember(id, pwd, name, phone, birth, email, gender);
			
			response.sendRedirect("main.jsp");
	}

}