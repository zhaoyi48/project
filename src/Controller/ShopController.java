package Controller;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ShopCar;
import Model.ShopModel;

/**
 * Servlet implementation class ShopController
 */
@WebServlet("/ShopController")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		try {
			if ("add".equals(method)) {
				this.add(req, resp);
			}
			else if("list".equals(method)){
				this.doGet(req, resp);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		ShopCar item=new ShopCar();
		item.setProductid(req.getParameter("pid"));
		item.setPrice(Double.parseDouble(req.getParameter("price")));
		item.setNum(Integer.parseInt(req.getParameter("num")));
		ShopModel ShopModel=new ShopModel();
		if(ShopModel.add(item)){
			System.out.println("success");
		}
		else{
			System.out.println("error product add");
		}
	}
private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		List list = new ShopModel().list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("shopcar.jsp").forward(req,resp);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.list(req, resp);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
