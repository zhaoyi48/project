package Controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		Map<String, String[]>  form = req.getParameterMap();
		String[] str = {"userid","password","username","password1","name","company","id","adress","phone","work","mphone","credit","adress1","rsph","email","rspid"};
		
		Set set = new HashSet();
		for(int i = 0;i < str.length; i++)
		{
			set.add(str[i]);
		}
	/*	for (String  key :form.keySet()) {
			if(form.get(key) == null && set.contains(key))
			{
				req.getRequestDispatcher("register.jsp").forward(req,resp);
			}
		}*/
		int id=Integer.parseInt(req.getParameter("userid"));
		String name=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		int access=Integer.parseInt(req.getParameter("access"));
		User user = new User(id,name,password,email,access);
		UserModel userModel = new UserModel();
		if(userModel.add(user)){
		req.getRequestDispatcher("login.jsp").forward(req,resp);
		}
	}

}
