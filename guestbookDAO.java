package ch11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch10.News;
import ch11.guestbook;

public class guestbookDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";
	
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"jWbook","1234");
			
		}catch (Exception e) {
		e.printStackTrace();
			}
		return conn;
	}


public int addguestbook (guestbook n)throws Exception {
	Connection conn = open();
	String sql = "insert into guestbook(id,name,email,date,title) values(?,?,?,CURRENT_TIMESTAMP(),?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	
	try(conn; pstmt){
		pstmt.setString(1, n.getName());
		pstmt.setString(2, n.getEmail());
		pstmt.setString(3, n.getTitle());
		return pstmt.executeUpdate();
		
		
	}
}
public List<guestbook> getAll() throws Exception {
	Connection conn = open();
	List<guestbook> newsList = new ArrayList<>();
	
	String sql = "select id,email,name ,title, PARSEDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate from guestbook";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	try(conn; pstmt; rs) { 
		while(rs .next() ) { 
			guestbook n = new guestbook();
			n.setId(rs.getInt("id"));
			n.setEmail(rs.getString("email"));
			n.setName(rs.getString("name"));
			n.setDate(rs.getString("cdate"));
			n.setTitle(rs.getString("title"));
			newsList.add(n);
		}
		return newsList;
		
	}
			
}

public void delGuestbook(int id) throws SQLException {
	Connection conn = open();
	String sql = "delete from guestbook where id =?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	
	try(conn; pstmt)	{
		pstmt.setInt(1, id);
		if(pstmt.executeUpdate()==0) { 
			throw new SQLException("DB에러");
			
		}
	}

}
}