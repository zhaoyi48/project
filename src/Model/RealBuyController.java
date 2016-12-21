package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RealBuy;
import Model.RealBuyModel;

/**
 * Servlet implementation class RealBuyController
 */
@WebServlet("/RealBuyController")
public class RealBuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RealBuyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		List list = new RealBuyModel().list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("realbuy.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.list(req, resp);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		try {
			if ("add".equals(method)) {
				this.add(req, resp);
			} else if ("list".equals(method)) {
				this.doGet(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		RealBuy item = new RealBuy();
		item.setPid(req.getParameter("pid"));
		item.setBuynum(Integer.parseInt((req.getParameter("price"))));
		item.setBuyuserid(req.getParameter("num"));
		item.setSelluserid(req.getParameter("num"));
		RealBuyModel RealSellModel = new RealBuyModel();
		if (RealSellModel.add(item)) {
			System.out.println("success");
		} else {
			System.out.println("error product add");
		}
	}

}
