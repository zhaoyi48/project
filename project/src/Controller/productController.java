package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import Model.ProductModel;

/**
 * Servlet implementation class productController
 */
@WebServlet("/productController")
public class productController extends HttpServlet {
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
			if ("add".equals(method)) {
				this.add(req, resp);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Product product=new Product();
		product.setPid(req.getParameter("pid"));
		product.setPname(req.getParameter("pname"));
		product.setPprice(Double.parseDouble(req.getParameter("pprice")));
		product.setNum(Integer.parseInt(req.getParameter("pnum")));
		product.setPclass(req.getParameter("class"));
		ProductModel productModel=new ProductModel();
		if(productModel.add(product)){
			
		}
		else{
			
		}
	}
	
}
