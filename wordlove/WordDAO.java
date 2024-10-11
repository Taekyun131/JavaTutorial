package wordlove;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class WordDAO {
	
	public static WordDAO wdao=null;
	private String username="system";
	private String password="11111111";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName="oracle.jdbc.driver.OracleDriver";
	private Connection conn=null; 
	
	private WordDAO() {
		init();
	}
	//싱글톤 디자인
	public static WordDAO getInstance() {
		if(wdao==null) {
			wdao=new WordDAO();
		}
		return wdao;
	}
	//오라클 드라이버 로드
	private void init() {
		try {
			Class.forName(driverName);
			System.out.println("오라클 드라이버 로드 성공");
		} catch (Exception e) {
			
		}
	}

	//오라클 커넥션 자원
	private boolean conn() {
		try {
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("커넥션 자원 획득 성공");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	//insert
	public void insert(WordDTO wdto) {
		if(conn()) {
			String sql="insert into wordlove values (?,?,word_no.nextval)";
			try {
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, wdto.getKor());
				psmt.setString(2, wdto.getEng());
				int result=psmt.executeUpdate();
				if(result!=0) {
					conn.commit();
					System.out.println("단어가 추가되었습다.");
				}else {
					conn.rollback();
					System.out.println("단어추가 실패");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	//전체보기
	public ArrayList<WordDTO> selectAll() {
		ArrayList <WordDTO>wlist=new ArrayList<>();
		if(conn()) {
			try {
				String sql="select * from wordlove order by wordNum";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					WordDTO wdto=new WordDTO();
					wdto.setEng(rs.getString("Eng"));
					wdto.setKor(rs.getString("kor"));
					wlist.add(wdto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return wlist;
	}
	//삭제하기
	public void delete(String Eng) {
		if(conn()) {
			try {
				String sql="delete from wordlove where Eng=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, Eng);
				int result=psmt.executeUpdate();
				if(result!=0) {
					conn.commit();
					System.out.println("삭제되었습니다.");
				}else {
					conn.rollback();
					System.out.println("삭제실패");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//수정하기
	public void update(String Eng, String Kor) {
		if(conn()) {
			try {
				String sql="update wordlove set kor=? where Eng=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, Kor);
				psmt.setString(2, Eng);
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("수정되었습니다.");
				}else {
					System.out.println("수정실패");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
