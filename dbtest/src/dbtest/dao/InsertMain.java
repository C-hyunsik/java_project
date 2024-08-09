package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "1234";
	
	private Connection con;				//인터페이스
	private PreparedStatement pstmt;	//인터페이스
	
	public InsertMain() {
		try {
			Class.forName(driver);		//생성
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
	public void insertArticle() {	//실제 insert시 connection 호출용도
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		
		//SQL
		this.getConnection();	//호출
		
		try {
			pstmt = con.prepareStatement("insert into dbtest values (?,?,?,sysdate)");	//가이드 생성
			
			//?에 데이터 매핑
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			
			//실행
			int su = pstmt.executeUpdate();	//실행 -> 개수 리턴
			System.out.println(su + "개의 행이 삽입되었습니다.");
			
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
		new InsertMain().insertArticle();
		
	}

}
