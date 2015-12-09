package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserManager;
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet{

	private static final long serialVersionUID = -8871806980834462884L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login=req.getParameter("login");
		String password=req.getParameter("password");
		RequestDispatcher dispatcher=null;
		UserManager userManager=new UserManager();
		int addUserResult=userManager.addUser(UserManager.createUser(login, password));
		HttpSession session=req.getSession();
		if(addUserResult==UserManager.UM_SUCCESS){	
			session.setAttribute("username", login);
			resp.sendRedirect("index");
		}
		else if(addUserResult==UserManager.UM_INVALID_USERNAME){
			req.setAttribute("errorMessage", "Пользователь "+login+"уже существует!");
			dispatcher=req.getRequestDispatcher("signUp.jsp");
		}
		else {
			req.setAttribute("errorMessage", "Непредвиденная ошибка!");
			dispatcher=req.getRequestDispatcher("signUp.jsp");
		}
		
		if(dispatcher!=null) dispatcher.forward(req, resp);
	}
	
	
}
