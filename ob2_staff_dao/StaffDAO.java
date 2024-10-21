package ob2_staff_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ob2_staff.Manager;
import ob2_staff.Owner;
import ob2_staff.Staff;

public class StaffDAO {
	//싱글톤 디자인
	public static StaffDAO sdao=null;
	public static StaffDAO getInstance() {
		if(sdao==null) {
			sdao=new StaffDAO();
		}
		return sdao;
	}
	
	ArrayList<Staff> slist=null;
	ArrayList<Manager> mlist=null;
	Owner [] olist=new Owner[1];
	Staff sdto=null;
	private String username="system";
	private String password="11111111";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName="oracle.jdbc.driver.OracleDriver";
	private Connection conn=null;
	
	private StaffDAO(){
		init();
	}
	
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
			e.printStackTrace();
		}
		return false;	//커넥션 자원을 획득하지 못한 경우
	}
	//직원 추가
	public void add(Staff s) {
		if(conn()) {
			try {
				String sql="insert into staff values(?,?,?,?,default)";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, s.getId());
				psmt.setString(2, s.getPwd());
				psmt.setString(3, s.getName());
				psmt.setString(4, s.getRank());
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("직원 채용완료");
					conn.commit();
				}else {
					System.out.println("직원 채용실패");
					conn.rollback();
				}
			} catch (Exception e) {
				// TODO: handle exception
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
	//직원삭제
	public void del(String name,String id) {
		if(conn()) {
			try {
				String sql="delete staff where name=? and id=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, name);
				psmt.setString(2, id);
				int result=psmt.executeUpdate();
				if(result!=0) {
					conn.commit();
					System.out.println("삭제가 완료되었습니다.");
				}else {
					conn.rollback();
					System.out.println("삭제 실패");
				}
			} catch (Exception e) {
				// TODO: handle exception
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
	//직원삭제(idx)
	public void del(int idx) {
		if(conn()) {
			try {
				String sql="delete (select row_number() over(order by decode(rank,'점주',1,'매니저',2,'사원',3),id) as num,id from staff) where num=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, idx);
				int result=psmt.executeUpdate();
				if(result!=0) {
					conn.commit();
					System.out.println("삭제되었습니다.");
				}else {
					conn.rollback();
					System.out.println("삭제실패");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//직원전체보기
	public ArrayList<Staff> all() {
		slist=new ArrayList<>();
		if(conn()) {
			try {
				String sql="select *from staff "
						+ "order by decode(rank,'점주',1,'매니저',2,'사원',3),id";
						 
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					sdto=new Staff();
					sdto.setId(rs.getString("id")); 
					sdto.setPwd(rs.getString("pwd"));
					sdto.setName(rs.getString("name"));
					sdto.setRank(rs.getString("rank"));
					sdto.setWorkTime(rs.getInt("wtime"));
					slist.add(sdto);
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
		return slist;
	}
	//회원정보수정
	public void modInfo(String id,String pwd,String name) {
		if(conn()) {
			try {
				String sql="update staff set pwd=?,name=? where id=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, pwd);
				psmt.setString(2, name);
				psmt.setString(3, id);
				int result=psmt.executeUpdate();
				if(result!=0) {
					conn.commit();
					System.out.println("변경완료되었습니다.");
				}else {
					conn.rollback();
					System.out.println("변경실패");
				}
			} catch (Exception e) {
				// TODO: handle exception
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
	//근무시간입력
	public void addWtime(Staff s,int wTime) {
		if(conn()) {
			try {
				String id=s.getId();
				String sql="update staff set wtime=wtime+? where id=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, wTime);
				psmt.setString(2, id);
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("입력이 완료되었습니다.");
					conn.commit();
				}else {
					System.out.println("입력실패");
					conn.rollback();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
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
	//수정된 정보 리턴
	public Staff returnStaff(Staff s) {
		if(conn()) {
			try {
				Staff temp=new Staff();
				String id=s.getId();
				String sql="select * from staff where id=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, s.getId());
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					temp.setId(rs.getString("id")); 
					temp.setPwd(rs.getString("pwd"));
					temp.setName(rs.getString("name"));
					temp.setRank(rs.getString("rank"));
					temp.setWorkTime(rs.getInt("wtime"));
					return temp;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
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
		return null;
	}
	//로그인 여부
	public Staff loginchk(String id,String pwd) {
		ArrayList<Staff>slist=all();
		for(Staff temp:slist) {
			if(temp.getId().equals(id)&&
					temp.getPwd().equals(pwd)){
				return temp;
			}
		}
		System.out.println("로그인 실패");
		return null;
	}
//	//직급확인
//	public Staff rankchk(Staff temp) {
//		if(temp!=null) {
//			if(temp.getRank().equals("사원")) {
//				return temp; 
//			}else if(temp.getRank().equals("매니저")){
//				Manager tempM=(Manager) temp;
//				return tempM;
//			}else if(temp.getRank().equals("점주")) {
//				Owner tempO=(Owner) temp;
//				return tempO;
//			}
//		}
//		return null;
//	}
//	public Staff loginchk(String id,String pwd) {
//		if(conn()) {
//			try {
//				String sql="select * from staff where id=? and pwd=?";
//				PreparedStatement psmt=conn.prepareStatement(sql);
//				psmt.setString(1,id);
//				psmt.setString(2,pwd);
//				ResultSet rs=psmt.executeQuery();
//				while(rs.next()) {
//					sdto=new Staff();
//					sdto.setId(rs.getString("id")); 
//					sdto.setPwd(rs.getString("pwd"));
//					sdto.setName(rs.getString("name"));
//					sdto.setRank(rs.getString("rank"));
//					if(sdto.getRank().equals("사원"))
//					return sdto;
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}finally {
//				if(conn!=null) {
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		System.out.println("로그인 실패");
//		return null;
//	}
	//매니저 로그인 여부
	public Manager loginMchk(String id, String pwd) {
		ArrayList<Manager>mlist=allM();
		mlist.add(showO());
		for(Manager t:mlist) {
			if(t.getId().equals(id)&&
					t.getPwd().equals(pwd)) {
				return t;
			}
		}
		return null;
	}
//		public Manager loginMchk(String id,String pwd) {
//			if(conn()) {
//				try {
//					String sql="select * from staff where id=? and pwd=? "
//							+ "and rank='매니저' or rank='점주'";
//					PreparedStatement psmt=conn.prepareStatement(sql);
//					psmt.setString(1,id);
//					psmt.setString(2,pwd);
//					ResultSet rs=psmt.executeQuery();
//					while(rs.next()) {
//						Manager mdto=new Manager();
//						mdto.setId(rs.getString("id")); 
//						mdto.setPwd(rs.getString("pwd"));
//						mdto.setName(rs.getString("name"));
//						mdto.setRank(rs.getString("rank"));
//						return mdto;
//					}
//				} catch (Exception e) {
//					// TODO: handle exception
//				}finally {
//					if(conn!=null) {
//						try {
//							conn.close();
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//			return null;
//		}
	
	//점주 로그인 여부
	public Owner loginOchk(String id,String pwd) {
		Owner temp=showO();
		if(temp.getId().equals(id)&&
				temp.getPwd().equals(pwd)) {
			return temp;
		}
		return null;
	}
//	public Owner loginOchk(String id,String pwd) {
//		if(conn()) {
//			try {
//				String sql="select * from staff where id=? and pwd=? and rank='점주'";
//				PreparedStatement psmt=conn.prepareStatement(sql);
//				psmt.setString(1,id);
//				psmt.setString(2,pwd);
//				ResultSet rs=psmt.executeQuery();
//				while(rs.next()) {
//					Owner odto=new Owner();
//					odto.setId(rs.getString("id")); 
//					odto.setPwd(rs.getString("pwd"));
//					odto.setName(rs.getString("name"));
//					odto.setRank(rs.getString("rank"));
//					return odto;
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}finally {
//				if(conn!=null) {
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		return null;
//	}
	
	
	
	//매니저 리스트
	private ArrayList<Manager> allM(){
		mlist=new ArrayList<>();
		if(conn()) {
			try {
				String sql="select * from staff where rank='매니저'";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					Manager mdto=new Manager();
					mdto.setId(rs.getString("id")); 
					mdto.setPwd(rs.getString("pwd"));
					mdto.setName(rs.getString("name"));
					mdto.setRank(rs.getString("rank"));
					mdto.setWorkTime(rs.getInt("wtime"));
					mlist.add(mdto);
				}
			} catch (Exception e) {
				// TODO: handle exception
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
		return mlist;
	}
	//점주
	private Owner showO() {
		Owner odto= new Owner();
		if(conn()) {
			try {
				String sql="select * from staff where rank='점주'";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					odto.setId(rs.getString("id")); 
					odto.setPwd(rs.getString("pwd"));
					odto.setName(rs.getString("name"));
					odto.setRank(rs.getString("rank"));
					odto.setWorkTime(rs.getInt("wtime"));
					return odto;
				}
			} catch (Exception e) {
				// TODO: handle exception
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
		return null;
	}
}
