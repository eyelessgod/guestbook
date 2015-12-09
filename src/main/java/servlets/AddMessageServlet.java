package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MessageManager;
@WebServlet("/addMessage")
public class AddMessageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6159214260484199627L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String content=req.getParameter("content");
		String username=(String) session.getAttribute("username");
		if(new MessageManager().addMessage(MessageManager.createMessage(username, content))){
			resp.sendRedirect("index");
		}
		else{
			
		}
		
		
	}

	
}
