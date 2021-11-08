package pattern.persistence;

import static pattern.persistence.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import pattern.domain.MemberDTO;

@AllArgsConstructor
public class MemberDAO {
	private Connection con;
	// 로그인
	public MemberDTO login(MemberDTO dto) {
		MemberDTO dto1 = null;
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select userid, name from member where userid=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto1 = new MemberDTO();
				dto1.setUserid(rs.getString("userid"));
				dto1.setName(rs.getString("name"));
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);			
		}
		return dto1;
	}

}
