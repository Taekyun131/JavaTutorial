package openIdea;

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

	
	public IdeaDAO(){
		init();
	}
	private boolean conn() {
		try {
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("커넥션 자원 획득 성공");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private void init() {
		try {
			Class.forName(driverName);
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void add(IdeaDTO idto) {
		if(conn()) {
			try {
				String sql="insert into idea values(idea_no.nextval,?,?,?)";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, idto.getTitle());
				psmt.setString(2, idto.getContent());
				psmt.setString(3, idto.getWriter());
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("추가되었습니다.");
				}else {
					System.out.println("추가 실패");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	public ArrayList<IdeaDTO> all(){
		ArrayList<IdeaDTO> ilist=new ArrayList<>();
		if(conn()) {
			String sql="select * from idea";
			try {
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					IdeaDTO idto=new IdeaDTO();
					idto.setTitle(rs.getString("title"));
					idto.setContent(rs.getString("content"));
					idto.setWriter(rs.getString("writer"));
					ilist.add(idto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		return ilist;
	}
	public void delete(String writer) {
		if(conn()) {
			try {
				String sql="delete from idea where writer=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, writer);
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("삭제되었습니다.");
				}else {
					System.out.println("삭제실패");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	public void update(IdeaDTO idto) {
		if(conn()) {
			try {
				String sql="update idea set title=?, content=? where writer=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, idto.getTitle());
				psmt.setString(2, idto.getContent());
				psmt.setString(3, idto.getWriter());
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("수정되었습니다");
				}else {
					System.out.println("수정실패");
				}
			} catch (Exception e) {
			}finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	
}
