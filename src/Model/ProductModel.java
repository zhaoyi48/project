package Model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Utils.DBUtils;

public class ProductModel {
	
	public boolean add(Product product) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}

			sql = "insert into T_PRODUCT(T_PRODUCTID,T_PRODUCTNAME,T_PRICE,T_PRODUCTTYPEID,T_NUM) values(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPid());
			pstmt.setString(2, product.getPname());
			pstmt.setDouble(3, product.getPprice());
			pstmt.setString(4, product.getPclass());
			pstmt.setInt(5, product.getNum());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				flag = true;
			}

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			DBUtils.release(pstmt, conn);
		}
		return flag;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List list() throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}
			// 数据保存 参数user对象中
			sql = "select * from T_PRODUCT";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product product=new Product();
				product.setPid(rs.getString("T_PRODUCTID"));
				product.setPname(rs.getString("T_PRODUCTNAME"));
				product.setPprice(rs.getDouble("T_PRICE"));
				product.setNum(rs.getInt("T_NUM"));
				list.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.release(rs, pstmt, conn);
		}

		return list;
	}
	
}
