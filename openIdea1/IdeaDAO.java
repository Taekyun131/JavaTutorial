package openIdea1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class IdeaDAO {
	private String username="system";
	private String password="11111111";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName="oracle.jdbc.driver.OracleDriver";
	private Connection conn=null;
	
	//싱글톤 디자인 코딩 시작
	public static IdeaDAO ideadao=null;
	private IdeaDAO() {
		init();
	}
	
	public static IdeaDAO getInstance() {
		if(ideadao==null) {
			ideadao=new IdeaDAO();
		}
		return ideadao;
	}
	//싱글톤 디자인 끝
	
	private void init() {//드라이버 로드
		try {
			Class.forName(driverName);
			System.out.println("오라클 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private boolean conn() {//커넥션 가져오는 공통 코드를 메서드로 정의
		try {
			conn=DriverManager.getConnection(
					url,username,password);
			System.out.println("커넥션 자원 획득 성공");
			return true;	//커넥션 자원을 정상적으로 획득할 시
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	//커넥션 자원을 획득하지 못한 경우
	}
	public void insert(IdeaDTO ideadto) {
		//커넥션, 쿼리, 매핑, 전송, 리턴값처리
		if(conn()) {
			try {
				String sql="insert into ideabank values "
						+ "(ideabank_seq.nextval,?,?,?,default)";
				//String을 쿼리문으로 인식하게 하는 작업
				PreparedStatement psmt=conn.prepareStatement(sql);
				//매핑
				psmt.setString(1, ideadto.getTitle());
				psmt.setString(2, ideadto.getContent());
				psmt.setString(3, ideadto.getWriter());
				//쿼리실행
//				psmt.executeUpdate();
				//쿼리실행 후 리턴값을 받아서 다음 처리작업 정의-트랜잭션 처리
				int resultInt=psmt.executeUpdate();
				if(resultInt>0){
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			System.out.println("데이터베이스 커넥션 실패");
		}
	}
	public ArrayList<IdeaDTO> selectAll(){
		ArrayList<IdeaDTO>idealist=new ArrayList<>();
		if(conn()) {
			try {
				String sql="select * from ideabank";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				//Resultset은 테이블 형식으로 가져온다고 이해
				while(rs.next()) {//next() 메서드는 rs에서 참조하는 테이블에서 
									//튜플을 순차적으로 하나씩 접근하는 메서드
					IdeaDTO ideaTemp=new IdeaDTO();
					//rs.getString("id") rs가 접근한 튜플에서 id컬럼의 값을 가져옴
					ideaTemp.setTitle(rs.getString("title"));
					ideaTemp.setNum(rs.getInt("num"));
					ideaTemp.setContent(rs.getString("content"));
					ideaTemp.setWriter(rs.getString("writer"));
					ideaTemp.setIndate(rs.getString("indate"));
					idealist.add(ideaTemp);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return idealist;
	}
	
	public void delete(int delNo) {
		if(conn()) {
			try {
				String sql="delete from ideabank where num=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, delNo);
				psmt.executeUpdate();
			} catch (Exception e) {
			}finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}
		}
	}
	public IdeaDTO selectOne(int modNum){
		if(conn()) {
			try {
				String sql="select * from ideabank where num=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, modNum);
				ResultSet rs=psmt.executeQuery();
				if(rs.next()) {	
					IdeaDTO iTemp=new IdeaDTO();
					iTemp.setTitle(rs.getString("title"));
					iTemp.setContent(rs.getString("content"));
					iTemp.setNum(rs.getInt("num"));
					iTemp.setWriter(rs.getString("writer"));
					return iTemp;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	public void update(IdeaDTO ideadto) {
		if(conn()) {
			try {
				String sql="update ideabank set title=?,content=? where num=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, ideadto.getTitle());
				psmt.setString(2, ideadto.getContent());
				psmt.setInt(3, ideadto.getNum());
				psmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		}
		
	}
	
	public ArrayList<IdeaDTO> select(String sw){
		ArrayList<IdeaDTO> ilist=new ArrayList<>();
		if(conn()) {
			try {
				String sql="select * from ideabank where "+
						"title like '%"+sw+"%'";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {	
					IdeaDTO iTemp=new IdeaDTO();
					iTemp.setContent(rs.getString("content"));
					iTemp.setIndate(rs.getString("indate"));
					iTemp.setTitle(rs.getString("title"));
					iTemp.setWriter(rs.getString("writer"));
					iTemp.setNum(rs.getInt("num"));
					ilist.add(iTemp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ilist;
	}
}
