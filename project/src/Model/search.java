package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBUtils;

public class search {
	public String getProduct() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}
			sql="select * from T_PRODUCT where T_PRODUCTNAME='"+ "" + "'";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			DBUtils.release(pstmt, conn);
		}
		return "";
	}
}
