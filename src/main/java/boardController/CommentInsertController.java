package boardController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentDAO;

@WebServlet("/CommentInsert")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fnum = request.getParameter("fnum");
		String comtext = request.getParameter("comtext");
		String comwriter = request.getParameter("comwriter");
		
		CommentDAO dao = new CommentDAO();
		
		dao.commentInsert(fnum, comtext, comwriter);
		
		
	}

}
