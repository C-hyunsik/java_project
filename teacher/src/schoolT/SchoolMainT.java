package schoolT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SchoolMainT {
	Scanner sc = new Scanner(System.in);
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "1234";
	
	private ResultSet rs;
	private Connection con;				//인터페이스
	private PreparedStatement pstmt;	//인터페이스
	
	public SchoolMainT() {
		try {
			Class.forName(driver);		//생성
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
	
	public void menu() {
		while(true) {
			System.out.println("****************\n"
							 + "      관리\n"
							 + "****************\n"
							 + "1. 입력\n"
							 + "2. 검색\n"	
							 + "3. 삭제\n"
							 + "4. 종료\n"
							 + "****************");
			System.out.print("번호선택 : ");
			int n = sc.nextInt();
		
			if(n == 4) {
				break;
			}
			else if(n == 1) 
				insertArticle();
			else if(n == 2) 
				selectArticle();
			else if(n == 3)
				deleteArticle();
			else{
				System.out.println("1 ~ 4 중에서 선택하세요.");
				continue;
			}
		}
	}
	
	private void insertArticle() {
		while(true) {
			System.out.println("****************\n"
							 + "1. 학생\n"
							 + "2. 교수\n"
							 + "3. 관리자\n"
							 + "4. 이전메뉴\n"
							 + "****************");
			System.out.print("번호선택 : ");
			int code = sc.nextInt();
			
			
			if(code == 4) break;
			
			String name = null;
			String value = "";
			System.out.print("이름 입력 : ");
			name = sc.next();
			
			if(code == 1) {
				System.out.print("학번 입력 : ");
				value = sc.next();
			}
			else if(code == 2) {
				System.out.print("과목 입력 : ");
				value = sc.next();
			}
			else if(code == 3) {
				System.out.print("부서 입력 : ");
				value = sc.next();
			}
			else{
				System.out.println("1 ~ 4 중에서 선택하세요");
				continue;
			}
			getConnection();
			try {
				pstmt = con.prepareStatement("insert into school values (?,?,?)");

				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setDouble(3, code);
				
				int su = pstmt.executeUpdate();
				System.out.println(su + " 행 이(가)  삽입되었습니다.");
				
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
		}//while
	}

	private void selectArticle() {
		
		while(true) {
			int n;
			System.out.println("****************\n"
					         + " 1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)\n"
					         + " 2. 전체 검색\n"
					         + " 3. 이전메뉴\n"
					         + "****************");
			System.out.print("번호 선택 : ");
			n = sc.nextInt();
			
			if(n == 3) break;
			System.out.println();
			String name = null;
			if(n == 1) {
				System.out.print("검색할 이름 입력 : ");
				name = sc.next();
			}
			
			getConnection();
			
			String sql;
			if(n == 1)
				sql = "select * from school where name like ?";
			else
				sql = "select * from school";
	
			try {
				pstmt = con.prepareStatement(sql);
				
				if(n == 1) pstmt.setString(1, "%" + name + "%");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					System.out.print("이름 = " + rs.getString("name") + "\t");
					
					if(rs.getInt("code") == 1)
						System.out.println("학번 = " + rs.getString("value"));
					else if(rs.getInt("code") == 2)
						System.out.println("과목 = " + rs.getString("value"));
					else if(rs.getInt("code") == 3)
						System.out.println("부서 = " + rs.getString("value"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(con !=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//while
	}
	
	private void deleteArticle() {
		System.out.print("삭제할 이름 입력 : ");
		String name = sc.next();

		getConnection();
		String sql = "delete school where name = ?";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + " 행 이(가) 삭제되었습니다.");
			
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
		new SchoolMainT().menu();
		System.out.println("프로그램을 종료합니다.");
	}

}
