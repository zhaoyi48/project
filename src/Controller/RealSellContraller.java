package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RealSell;
import Model.RealSellModel;
/**
 * Servlet implementation class RealSellContraller
 */
@WebServlet("/RealSellContraller")
public class RealSellContraller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealSellContraller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
	

	
	
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		RealSell item=new RealSell();
		item.setPid(req.getParameter("pid"));
		item.setBuynum(Integer.parseInt((req.getParameter("price"))));
		item.setBuyuserid(req.getParameter("num"));
		item.setSelluserid(req.getParameter("num"));
		RealSellModel RealSellModel=new RealSellModel();
		if(RealSellModel.add(item)){
			System.out.println("success");
		}
		else{
			System.out.println("error product add");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		List list = new RealSellModel().list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("realsell.jsp").forward(req,resp);
	}
}
