package board2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import board2.bean.Board2DTO;

public class Board2DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "1234";
	
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;

	public static Board2DAO instance = new Board2DAO();
	
	public static Board2DAO getInstance() {
		return instance;
	}
	
	public Board2DAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void write(String id, String name, String subject, String content) {
		getConnection();
		
		String sql = "insert into board_java values(board_java_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(pstmt != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void list(Board2DTO board2dto) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		getConnection();
		
		String sql = "select * from board_java order by seq desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("seq") + "\t" + 
								   rs.getString("subject") + "\t" + 
								   rs.getString("id") + "\t" + 
								   sdf.format(rs.getDate("logtime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(pstmt != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public void view(int seq) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		getConnection();
		
		String sql = "select * from board_java where seq = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("글번호 : " + rs.getInt("seq") + 
								   "\t아이디 : " + rs.getString("id") + 
								   "\t이름 : " + rs.getString("name"));
				System.out.println("날짜 : " + sdf.format(rs.getDate("logtime")));
				System.out.println("내용 : " + rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(pstmt != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
