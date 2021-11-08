package member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.domain.MemberDTO;

import static member.persistence.JdbcUtil.*;

public class MemberDAO {
	private Connection con;
	
	public MemberDAO(Connection con) {
		this.con = con;
		
	}
	
	// login => select
	public MemberDTO isLogin(String userid, String password) {
		MemberDTO loginDto = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		
		try {
			String sql = "select userid, name from member where userid =? and password=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginDto = new MemberDTO();
				loginDto.setUserid(rs.getString(1));
				loginDto.setName(rs.getString(2));
			}
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginDto;
	}
	
	// 비밀번호 변경
	
	
	
	
}
