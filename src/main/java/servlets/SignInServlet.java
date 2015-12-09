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

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

	private static final long serialVersionUID = 944438044680815141L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String login=(String) req.getParameter("login");
		String password=(String)req.getParameter("password");
		RequestDispatcher dispatcher=null;
		UserManager userManager=new UserManager();
		int validationResult=userManager.validate(login, password);
		if(validationResult==UserManager.UM_SUCCESS){
			HttpSession session=req.getSession();
			session.setAttribute("username", login);
			resp.sendRedirect("index");
		}
		else if(validationResult==UserManager.UM_INVALID_USERNAME){
			req.setAttribute("errorMessage", "Пользователь "+login+" не найден!");
			dispatcher=req.getRequestDispatcher("signIn.jsp");
		}
		else if(validationResult==UserManager.UM_INVALID_PASSWORD){
			req.setAttribute("errorMessage", "Неверный пароль!");
			dispatcher=req.getRequestDispatcher("signIn.jsp");
		}
		else{
			req.setAttribute("errorMessage", "Непредвиденная ошибка");
			dispatcher=req.getRequestDispatcher("signIn.jsp");
		}
		if(dispatcher != null)
				dispatcher.forward(req, resp);
		
	}
	
}
