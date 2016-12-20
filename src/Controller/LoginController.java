package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Model.UserModel;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		System.out.println(method);
		try {
			if ("login".equals(method)) {
				this.login(req, resp);
			}
			else if ("logout".equals(method)) {
				this.logout(req,resp);
			}
			else if ("sign".equals(method)) {
				this.sign(req,resp);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sign(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getSession().invalidate();
		req.getRequestDispatcher("login.jsp").forward(req,resp);
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserid(Integer.parseInt(req.getParameter("userid")));
		System.out.println(user.getUserid());
		user.setPassword(req.getParameter("password"));
		UserModel userModel = new UserModel();
		int access=userModel.checkUser(user);
		if (access!=-1) {
			req.getSession().setAttribute("userid", user.getUserid());
			req.getSession().setAttribute("access", access);
			req.getRequestDispatcher("commodity.jsp").forward(req,resp);
		} 
		else {
			req.setAttribute("msg", "error");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
		}
	}
	
	
}
