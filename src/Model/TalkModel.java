package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
