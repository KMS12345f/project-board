package boardController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.CommentDTO;
import service.CommentDAO;

@WebServlet("/Comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String num = request.getParameter("fnum");
		  int fnum = Integer.parseInt(num);
		
		  response.setContentType("application/json");
		  request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8");
		  

		  CommentDAO dao = new CommentDAO();
		  
		  List<CommentDTO> select = dao.commentList(fnum);
		  
		  String c_list = new Gson().toJson(select);
		  response.getWriter().println(c_list);
		 
	}	
}
