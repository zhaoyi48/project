package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.DBUtils;

public class search {
	public void getProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			//conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}
	//		sql="select (T_PRODUCTID,T_PRODUCTNAME,T_PRICE,T_NUM,T_SELLUSERID,T_POSTAGE) from T_PRODUCT where T_PRODUCTNAME='"+ "" + "'";
			sql = "select * from T_PRODUCT";
			System.out.println(sql);
			//pstmt = conn.prepareStatement(sql);
			
<<<<<<< HEAD
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			PrintWriter writer=resp.getWriter();
		while(rs.next()){
			System.out.println("xxxxxxx");
				writer.print(rs.getString("T_PRODUCTID"));
				writer.print("             " );
				writer.print(rs.getString("T_PRODUCTNAME"));
				writer.print("             " );
				writer.print(rs.getString("T_PRODUCTNAME"));
				writer.print("             " );
				System.out.println("xxfffffffxxxxx");
				
		 } 
		}
		catch (SQLException e) {
=======
			//rs = pstmt.executeQuery();
			PrintWriter writer=resp.getWriter();
			writer.append("<table><tr>"
					+ "<td>商品名</td>"
					+ "</tr><tr>"
					+ "<td>商品编号</td>"
					+ "<td>商品名</td>"
					+ "<td>单价</td>"
					+ "<td>现存数量</td>"
					+ "<td>卖家</td>"
					+ "<td>邮费</td>"
					+ "</tr>");
			/*while(rs.next()){
				writer.println("test");
			}*/
			writer.println("</table>");
		} 
		catch (Exception e) {
>>>>>>> origin/master
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			//DBUtils.release(pstmt, conn);
		}
	}
}
