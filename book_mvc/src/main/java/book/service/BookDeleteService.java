package book.service;

import java.sql.Connection;
import static book.persistence.JdbcUtil.*;

import book.persistence.BookDAO;
import oracle.jdbc.OracleConnection.CommitOption;

public class BookDeleteService {
	public boolean bookDelete(String code) {
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		boolean deleteFlag= dao.delete(code);
		
		if(deleteFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return deleteFlag;
	}
}
