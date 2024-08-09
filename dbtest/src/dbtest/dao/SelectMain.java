package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "1234";
	private ResultSet rs;
	
	private Connection con;				//인터페이스
	private PreparedStatement pstmt;	//인터페이스

	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public SelectMain() {
		try {
			Class.forName(driver);		//생성
			System.out.println("driver loading");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void selectArticle() {
		getConnection();
		
		String sql = "select * from dbtest";
		try {
			pstmt =con.prepareStatement(sql);
			
			//실행
			rs = pstmt.executeQuery();	//실행 쿼리의 결과물을 ResultSet에 담아옴	select만 쿼리
			while(rs.next()) {
				System.out.println(rs.getString("name")
						  + "\t" + rs.getInt("age")
						  + "\t" + rs.getDouble("height")
						  + "\t" + rs.getString("logtime"));
			}//while
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		new SelectMain().selectArticle();
	}

}
