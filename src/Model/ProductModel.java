package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
