package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Talk;
import Model.TalkModel;

/**
 * Servlet implementation class TalkController
 */
@WebServlet("/TalkController")
public class TalkController extends HttpServlet {
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

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Talk talk=new Talk();
		talk.setSend(1);
		talk.setReceive(1);
		talk.setText("");
		TalkModel talkModel=new TalkModel();
		if(talkModel.add(talk)){
			System.out.println("talk success");
		}
		else{
			System.out.println("error talk add");
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		List list = new TalkModel().list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("talk.jsp").forward(req,resp);
	}

	@Override
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
