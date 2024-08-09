package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "1234";

	private Connection con;				//인터페이스
	private PreparedStatement pstmt;	//인터페이스
	private ResultSet rs;				//인터페이스

	//private static MemberDAO instance;	//싱글톤
	private static MemberDAO instance = new MemberDAO();	//어차피 한번 생성 if문 필요x

	public MemberDAO() {
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
	public static MemberDAO getInstance() {
		/*
		if(instance == null) {					//instance가 null값이라면(처음한번)

			synchronized (MemberDAO.class) {	//한번에 한명만 스레드에 들어와서
				instance = new MemberDAO();		//Member DAO 생성
			}
		}
		 */
		return instance;
	}
	public int write(MemberDTO memberDTO) {
		int su = 0;

		getConnection();	//접속

		String sql = "insert into member values(?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(sql);	//생성

			//매핑
			pstmt.setString(1,memberDTO.getName());
			pstmt.setString(2,memberDTO.getId());
			pstmt.setString(3,memberDTO.getPw());
			pstmt.setString(4,memberDTO.getPhone());

			su = pstmt.executeUpdate();	//실행

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return su;
	}
	public boolean isExistId(String id) {
		boolean exist = false;
		getConnection();	

		try {
			String sql = "select * from member where id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				exist = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return exist;
	}
	public String login(String id, String pw) {
		getConnection();	
		String name = null;
		try {
			String sql = "select name from member where id = ? and pw = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return name = rs.getString("name");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return name;
	}
	public String search(String id) {
		String id1 = null;
		getConnection();
		String sql = "select * from member where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
					System.out.println(rs.getString("name")
							  + "\t" + rs.getString("id")
							  + "\t" + rs.getString("pw")
							  + "\t" + rs.getString("phone"));
				
				id1 = rs.getString("id");
			}
		}catch (SQLException e) {
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
		
		return id1;
	}
	public int update(String name, String pw, String id1) {
		int su = 0;

		getConnection();
		
		String sql = "update member set name = ?, pw = ? where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,pw);
			pstmt.setString(3,id1);
			
			su = pstmt.executeUpdate();
			
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
		
		return su;
	}
	public int delete(String id, String pw) {
		int su = 0;
		
		getConnection();
		
		String sql = "delete member where id = ? and pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
	public boolean deleteSearch(String pw) {
		boolean exist2 = false;
		getConnection();
		
		String sql = "select * from member where pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				exist2 = true;
			}
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
		return exist2;
	}
}
