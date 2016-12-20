package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBUtils;



public class UserModel {
	
	public int checkUser(User user) {
		int flag = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = DBUtils.getConnection();
			String sql = "select * from T_USERS where T_USERID='"+ user.getUsername() + "'";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			System.out.println("sql=" + sql);
			if (rs.next()) {
				if (user.getPassword().equals(rs.getString("T_USERPASS"))) {
					int access=rs.getInt("T_ACCESS");
					flag = access;
					return flag;
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			DBUtils.release(rs, pstmt, conn);
		}
		return flag;
	}
	
	
	public boolean add(User user) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}

			sql = "insert into T_USERS(T_USERID,T_NAME,T_USERPASS,T_MAIL,T_ACCESS) values(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setInt(4, user.getAccess());

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
	
	public int getId() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.out.println("conn null");
			}
			sql="select * from T_USERS";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			int rowCount = 0;
			while (rs.next()) {
				rowCount++;	
			}
			return rowCount+1;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			DBUtils.release(pstmt, conn);
		}
		return -1;
	}
}
