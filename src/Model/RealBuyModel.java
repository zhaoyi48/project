package Model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;

public class RealBuyModel  {
	public boolean add( RealBuy items) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}

			sql = "insert into T_REALBUY(T_PRODUCTID,T_BUYNUM,T_BUYUSERID,T_SELLUSERID) values(?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, items.getPid());
			pstmt.setInt(2, items.getBuynum());
			pstmt.setString(3, items.getBuyuserid());
			pstmt.setString(4, items.getSelluserid());
			

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
			sql = "select * from  T_REALBUY";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				 RealSell realsell = new  RealSell();

				 realsell.setPid(rs.getString("T_PRODUCTID"));
				 realsell.setBuynum(rs.getInt("T_BUYNUM"));
				 realsell.setBuyuserid(rs.getString("T_BUYUSERID"));
				 realsell.setSelluserid(rs.getString("T_SELLUSERID"));

				list.add(realsell);
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
