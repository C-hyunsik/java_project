package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;

import board.bean.BoardDTO;

public class BoardDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "1234";
	
	private Connection con;				//인터페이스
	private PreparedStatement pstmt;	//인터페이스
	private ResultSet rs;				//인터페이스

	//private static MemberDAO instance;	//싱글톤
	private static BoardDAO instance = new BoardDAO();	//어차피 한번 생성 if문 필요x
	
	public BoardDAO() {
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

	public static BoardDAO getInstance() {
		
		return instance;
	}
	
	public int write(BoardDTO boardDTO) {
		int su = 0;

		getConnection();	//접속

		String sql = "insert into Board_java values(board_java_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		try {
			//생성
			pstmt = con.prepareStatement(sql);
			//매핑
			pstmt.setString(1,boardDTO.getId());
			pstmt.setString(2,boardDTO.getName());
			pstmt.setString(3,boardDTO.getSubject());
			pstmt.setString(4,boardDTO.getContent());

			su = pstmt.executeUpdate();	//실행

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

	public void list(BoardDTO boardDTO) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		getConnection();
		String sql = "select * from Board_java order by seq desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("seq") + "\t" + 
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
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void view(int seq) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		getConnection();
		String sql = "select * from Board_java where seq = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,seq);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("글번호 : " + rs.getInt("Seq")
								 + "\t아이디 : " + rs.getString("id")
								 + "\t이름 : " + rs.getString("name"));
				System.out.println("날짜 : " + sdf.format(rs.getDate("logtime")));
				System.out.println("내용 : " + rs.getString("content"));
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
	}
}
