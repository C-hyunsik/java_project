package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "1234";
	
	private Connection con;
	private PreparedStatement pstmt;
	
	public UpdateMain() {
		try {
			Class.forName(driver);
			System.out.println("driver loading");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void UpdateArticle() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		getConnection();
		
		try {
			pstmt = con.prepareStatement("update dbtest set age = age + 1 where name like ?");
			
			pstmt.setString(1, "%" + name + "%");
			
			int su = pstmt.executeUpdate();
			System.out.println("실행");
			
			System.out.println(su + "건의 행이 업데이트되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(con !=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		new UpdateMain().UpdateArticle();
	}

}