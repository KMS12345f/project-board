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
import service.sha256;


@WebServlet("/shacheck")
public class shaCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String userpwd = request.getParameter("pwd");

		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
		
	    // DAO적용 시킨거라고 보면됨
	    String encryptSHA256 = sha256.testSHA256(id, userpwd);

	    if(userpwd.equals(encryptSHA256)) {
	    	out.println("<script>alert('정상 로그인 하셨습니다.');</script>");
			out.println("<script>window.location.href='login.jsp';</script>");
	    }
	    else {
	    	out.println("<script>alert('로그인 실패 확인바랍니다.');</script>");
			out.println("<script>window.location.href='login.jsp';</script>");
	    }
	    
	}

}
