package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MessageManager;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = -3792047100550048731L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		
		HttpSession session=req.getSession(true);
		String username=(String) session.getAttribute("username");
		if(username!=null){
			req.setAttribute("username", username);
		}
		req.setAttribute("messages", new MessageManager().getMessages());
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);

	}
}
