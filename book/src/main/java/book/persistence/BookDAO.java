package book.persistence;

import static book.persistence.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import book.domain.BookDTO;

public class BookDAO {

	private Connection con;
	
	public BookDAO(Connection con) {
		this.con = con;
	}
	
	// insert
	public boolean insert(BookDTO insertDTO) {
		String sql = "insert into bookTBL values(?, ?, ?, ?)";
		boolean insertFlag=false;
		
		PreparedStatement pstmt = null;
		
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, insertDTO.getCode());
			pstmt.setString(2, insertDTO.getTitle());
			pstmt.setString(3, insertDTO.getWriter());
			pstmt.setInt(4, insertDTO.getPrice());
			
			int result = pstmt.executeUpdate();
			
			if(result >0)insertFlag =true;
					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		return insertFlag;
	}
	
	
	// delete
	public boolean delete(String code) {
		boolean deleteFlag = false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from bookTBL where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			
			int result = pstmt.executeUpdate();
			if(result>0) deleteFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return deleteFlag;
		
	}

	// update
	public boolean update(String code, int price) {
		boolean updateFlag = false;
		PreparedStatement pstmt = null;
		
		try {
			String sql ="update bookTBL set price=? where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, "code");
			
			int result = pstmt.executeUpdate();
			if(result>0) updateFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return updateFlag;
		
		
	}
	
	// select 전체조회
	public List<BookDTO> list(){
		List<BookDTO> bookList = new ArrayList<BookDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from bookTBL";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				
				bookList.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		} return bookList;
	}
	
	// 검색
	public List<BookDTO> search(String criteria, String keyword){
		
		List<BookDTO> booklist = new ArrayList<BookDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from bookTBL where "+criteria+"=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				
				booklist.add(dto);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}return booklist;
		
	}
	
	
	
	
	
	
	
	
}
