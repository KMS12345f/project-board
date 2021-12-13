package boardController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FreeBoardDTO;
import service.FreeBoardDAO;

@WebServlet("/BoardUpdateList")
public class BoardUpdateList extends HttpServlet {
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
		
		
		if(sessionName.equals(writer)) {
			FreeBoardDAO dao = new FreeBoardDAO();
			List<FreeBoardDTO> list = dao.selectOneList(fNum);
			
			String page = "update.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);  
			
			request.setAttribute("list", list);
			dispatcher.forward(request, response);
			
		 }else if(sessionName.equals("admin")){
			 
			 FreeBoardDAO dao = new FreeBoardDAO();
			 List<FreeBoardDTO> list = dao.selectOneList(fNum);
				
			 String page = "update.jsp";
			 RequestDispatcher dispatcher = request.getRequestDispatcher(page);  
				
			 request.setAttribute("list", list);
			 dispatcher.forward(request, response);
		  }else {
			  System.out.println("==========비작동");
			  out.println("<script>alert('권한이 없습니다.');</script>");
			  out.println("<script>window.location.href='BoardView';</script>"); 
		  }
		
		

	}

}
