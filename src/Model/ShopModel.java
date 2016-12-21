package Model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;

public class ShopModel {
	public boolean add(ShopCar items) {
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
			pstmt.setString(1, items.getProductid());
			pstmt.setInt(2, items.getNum());
			pstmt.setDouble(3, items.getPrice());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.release(pstmt, conn);
		}
		return flag;
	}

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
			sql = "select * from  T_WANTBUY";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopCar shopcar = new ShopCar();

				shopcar.setProductid(rs.getString("T_PRODUCTID"));
				shopcar.setNum(rs.getInt("T_BUYNUM"));
				shopcar.setPrice(rs.getDouble("T_PRICE"));

				list.add(shopcar);
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
