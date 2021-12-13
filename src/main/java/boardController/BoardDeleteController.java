package boardController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FreeBoardDAO;


@WebServlet("/BoardDelete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fNum = request.getParameter("fnum");
		String writer = request.getParameter("writer");
		HttpSession session = request.getSession();
		String sessionName = (String) session.getAttribute("userId");

		System.out.println(fNum);
		System.out.println(writer);
		System.out.println(sessionName);
		
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     PrintWriter out = response.getWriter();

	     if(sessionName.equals("admin")){
			 FreeBoardDAO dao = new FreeBoardDAO();
			  System.out.println("==========�۵�");
			  dao.deleteFree(fNum);
			  response.sendRedirect("BoardView");
		    
		 }else if(sessionName.equals(writer)) {
			  FreeBoardDAO dao = new FreeBoardDAO();
			  System.out.println("==========�۵�");
			  dao.deleteFree(fNum);
			  response.sendRedirect("BoardView");
			  
		  }else {
			  System.out.println("==========���۵�"); 
			  out.println("<script>alert('������ �����ϴ�.');</script>");
			  out.println("<script>window.location.href='BoardView';</script>"); 
		  }
		
		
		
		
	
	}

}
