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


@WebServlet("/shainsert")
public class shainsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String userpwd = request.getParameter("pwd");

		
	    // DAO���� ��Ų�Ŷ�� �����
	    String encryptSHA256 = sha256.insertSHA256(id, userpwd);
	    System.out.println("SHA256 �ϱ� ���� " + userpwd);
	    System.out.println("SHA256 ���� �� " + encryptSHA256);
		  
	}

}
