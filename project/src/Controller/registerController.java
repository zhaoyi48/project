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
 * Servlet implementation class registerController
 */
@WebServlet("/registerController")
public class registerController extends HttpServlet {
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
		try {
			if ("register".equals(method)) {
				this.register(req, resp);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("userid"));
		String name=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		User user = new User(id,name,password,email);
		UserModel userModel = new UserModel();
		userModel.add(user);
		req.getRequestDispatcher("login.jsp").forward(req,resp);
	}

}
