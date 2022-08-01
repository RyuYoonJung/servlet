package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Member;
import utils.DBConn;

public class MemberDao {
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {
		return memberDao;
	}
	private MemberDao() {}
	
	public void register(Member member) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "INSERT INTO TBL_MEMBER(ID, PW, NAME) VALUES(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, member.getId());
			pstmt.setString(idx++, member.getPw());
			pstmt.setString(idx++, member.getName());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Member login(String id, String pw) {
		Member member = null;
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM TBL_MEMBER WHERE ID = ? AND PW = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, id.trim());
			pstmt.setString(idx++, pw.trim());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public void remove(String id) {
		try {
			Connection conn = DBConn.getConnection();
//			String sql = "DELETE TBL_MEMBER \r\n" + 
//					"WHERE ID = ?";
			String sql = "{call quit_proc(?)}";
			CallableStatement pstmt = conn.prepareCall(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
