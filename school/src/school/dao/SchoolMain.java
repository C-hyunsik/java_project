package school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SchoolMain {
	Scanner sc = new Scanner(System.in);
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "1234";
	
	private ResultSet rs;
	private Connection con;				//인터페이스
	private PreparedStatement pstmt;	//인터페이스
	
	public SchoolMain() {
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
	
	public void menu() {
		while(true) {
			System.out.println("****************\n"
							 + "관리\n"
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
			else if(n == 1) {
				insertArticle();
			}
			else if(n == 2) {
				selectArticle();
			}
			else if(n == 3) {
				deleteArticle();
			}
			else{
				System.out.println("1 ~ 4 중에서 선택하세요.");
				continue;
			}
		}
	}
	
	public void insertArticle() {	//실제 insert시 connection 호출용도
		while(true) {
			System.out.println("****************\n"
							 + "1. 학생\n"
							 + "2. 교수\n"
							 + "3. 관리자\n"
							 + "4. 이전메뉴\n"
							 + "****************");
			System.out.print("번호선택 : ");
			int code = sc.nextInt();
			
			if(code == 4) return;
			else if(code == 1) {
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("학번 입력 : ");
				int value = sc.nextInt();
				
				getConnection();
				try {
					pstmt = con.prepareStatement("insert into school values (?,?,?)");
					
					pstmt.setString(1, name);
					pstmt.setInt(2, value);
					pstmt.setDouble(3, code);
					
					int su = pstmt.executeUpdate();
					System.out.println(su + " 행 이(가) 삽입되었습니다.");
					
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
			else if(code == 2) {
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("과목 입력 : ");
				String value = sc.next();
				
				getConnection();
				try {
					pstmt = con.prepareStatement("insert into school values (?,?,?)");

					pstmt.setString(1, name);
					pstmt.setString(2, value);
					pstmt.setDouble(3, code);
					
					int su = pstmt.executeUpdate();
					System.out.println(su + " 행 이(가) 삽입되었습니다.");
					
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
			else if(code == 3) {
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("부서 입력 : ");
				String value = sc.next();
				
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
			}
			else{
				System.out.println("1 ~ 4 중에서 선택하세요");
				continue;
			}
		}//while
	}
	
	public void selectArticle() {
		while(true) {
			System.out.println("****************\n"
					         + " 1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)\n"
					         + " 2. 전체 검색\n"
					         + " 3. 이전메뉴\n"
					         + "****************");
			System.out.print("번호 선택 : ");
			int n = sc.nextInt();
			
			if(n == 3) return;
			else if(n == 1) {
				System.out.print("검색할 이름 입력 : ");
				String name = sc.next();
				getConnection();
				String sql = "select * from school where name like ?";
				
				try {
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "%" + name + "%");
					
					rs = pstmt.executeQuery();
					while(rs.next()) {
						String name1 = rs.getString("name");
						String value1 = rs.getString("value");
						int code1 = rs.getInt("code");
						if(code1 == 1)
							System.out.println("이름 = " + name1 + " 학번 = " + value1);
						else if(code1 == 2)
							System.out.println("이름 = " + name1 + " 과목 = " + value1);
						else if(code1 == 3)
							System.out.println("이름 = " + name1 + " 부서 = " + value1);
					}
					
				} catch (SQLException e) {
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
				
			}
			else if(n == 2) {
				getConnection();
				String sql = "select * from school";

				try {
					pstmt = con.prepareStatement(sql);

					rs = pstmt.executeQuery();
					while(rs.next()) {
						String name1 = rs.getString("name");
						String value1 = rs.getString("value");
						int code1 = rs.getInt("code");
						if(code1 == 1)
							System.out.println("이름 = " + name1 + " 학번 = " + value1);
						else if(code1 == 2)
							System.out.println("이름 = " + name1 + " 과목 = " + value1);
						else if(code1 == 3)
							System.out.println("이름 = " + name1 + " 부서 = " + value1);
					}
				}catch (SQLException e) {
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
			}
			else continue;
		}
	}
	
	public void deleteArticle() {
		while(true) {
			System.out.print("삭제할 이름 입력 : ");
			String name = sc.next();
			getConnection();
			try {
				pstmt = con.prepareStatement("delete school where name = ?");
				
				pstmt.setString(1, name);
				
				int su = pstmt.executeUpdate();
				if(su != 0) {
					System.out.println(su + " 행 이(가) 삭제되었습니다.");
					break;
				}
				else {
					System.out.println("이름이 정확하지 않습니다.");
					continue;
				}
				
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
	}
	
	public static void main(String[] args) {
		new SchoolMain().menu();
		System.out.println("프로그램을 종료합니다.");

	}

}
/*
# 테이블 작성
create table school (
 name  varchar2(15)  not  null, -- 이름
value  varchar2(15), -- 학번 or 과목 or 부서
code   number   -- 1이면 학생, 2이면 교수, 3이면 관리자
);
menu()
****************
관리
****************
1. 입력
2. 검색	//제외
3. 삭제
4. 종료
****************
번호선택 : 4
프로그램 종료합니다
-------------------------------------------------------
1번인 입력인 경우 - insertArticle()
 ****************
1. 학생
2. 교수
3. 관리자
4. 이전메뉴
****************
번호선택 : 
1-1번 학생인 경우
이름 입력 : 
학번 입력 : 
1-2번 교수인 경우
이름 입력 : 
과목 입력 : 
1-3번 관리자인 경우
이름 입력 : 
부서 입력 : 
1 행이 삽입되었습니다.
-------------------------------------------------------
2번 검색인 경우 - selectArticle()
 ****************
 1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)
 2. 전체 검색
3. 이전메뉴
****************
번호선택 : 1
 2-1번 이름 검색인 경우
검색할 이름 입력 : 이
이름 = 이교수 과목= 자바
이름 = 이관리 부서= 기획
이름 = 이학생 학번= 2002

 2-2번 전체 검색인 경우
이름 = 이교수 과목 = 자바
이름 = 코난 학번 = 2022
이름 = 홍길동 학번 = 2000
이름 = 이관리 부서 = 기획
이름 = 김교수 과목 = C
이름 = 이학생 학번 = 2002
-------------------------------------------------------
 3번 삭제인 경우 - deleteArticle()
삭제를 원하는 이름 입력 : (정확하게 3개의 글자가 모두 입력된 상태)
 x개 행이 삭제되었습니다.
*/