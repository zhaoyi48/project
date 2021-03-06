package Model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;

public class TalkModel {
	public boolean add(Talk talk) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}

			sql = "insert into T_TALK(T_SENDER,T_ACCEPTER,T_TALKCONTENT) values(?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, talk.getSend());
			pstmt.setInt(2, talk.getReceive());
			pstmt.setString(3, talk.getText());

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
			sql = "select * from T_TALK";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Talk talk=new Talk();
				talk.setSend(rs.getInt("T_SENDER"));
				talk.setReceive(rs.getInt("T_ACCEPTER"));
				talk.setText(rs.getString("T_TALKCONTENT"));
			
				list.add(talk);
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
