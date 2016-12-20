package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Utils.DBUtils;

public class ShopModel {
	public boolean add(ShopItem item) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}

			sql = "insert into T_WANTBUY(T_PRODUCTID,T_BUYNUM,T_PRICE) values(?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getProductid());
			pstmt.setInt(2, item.getNum());
			pstmt.setDouble(3, item.getPrice());

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
