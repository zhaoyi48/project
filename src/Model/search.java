package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBUtils;

public class search {
	public ResultSet getProduct() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}
			sql="select (T_PRODUCTID,T_PRODUCTNAME,T_PRICE,T_NUM,T_SELLUSERID,T_POSTAGE) from T_PRODUCT where T_PRODUCTNAME='"+ "" + "'";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			return rs;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			DBUtils.release(pstmt, conn);
		}
		return null;
	}
}
