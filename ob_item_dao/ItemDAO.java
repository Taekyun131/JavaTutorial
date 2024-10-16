package ob_item_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ob_item.ItemDTO;

public class ItemDAO {
	public static ItemDAO idao=null;
	//싱글톤 디자인
	private ItemDAO() {
		init();
	}
	public static ItemDAO getInstance() {
		if(idao==null) {
			idao=new ItemDAO();
		}
		return idao;
	}
	ItemDTO idto=null;
	private String username="system";
	private String password="11111111";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName="oracle.jdbc.driver.OracleDriver";
	private Connection conn=null;
	
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
	
	//발주하기
	public void orderItem(int selNum,int qty) {
		if(conn()) {
				try {
					String sql="update nowitem set qty=qty+? where no=?";
					PreparedStatement psmt=conn.prepareStatement(sql);
					psmt.setInt(1, qty);
					psmt.setInt(2,selNum);
					int result=psmt.executeUpdate();
					if(result>0) {
						System.out.println("발주완료");
						conn.commit();
					}else {
						System.out.println("발주실패");
						conn.rollback();
					}
				} catch (Exception e) {
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
	
	//발주시트 등록
		public void addOrder(String mname,int selNum,int qty) {
			if(conn()) {
				try {
					int price=0;
					String item=null;
					String sql="select * from nowitem where no=? ";
					PreparedStatement psmt=conn.prepareStatement(sql);
					psmt.setInt(1, selNum);
					ResultSet rs=psmt.executeQuery();
					while(rs.next()) {
						price= rs.getInt("price");
						item=rs.getString("name");
					}
					sql="insert into return values(?,?,?,?)";
					psmt=conn.prepareStatement(sql);
					psmt.setString(1, mname);
					psmt.setString(2, item);
					psmt.setInt(3, qty);
					psmt.setInt(4, price);
					int result=psmt.executeUpdate();
					if(result!=0) {
						System.out.println("발주시트 등록완료");
						conn.commit();
					}else {
						System.out.println("발주시트 등록실패");
						conn.rollback();
					}
					
				} catch (Exception e) {
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

//	//테이블에 식재 중복여부
//	public boolean dupItem(String name) {
//		if(conn()) {
//			try {
//				String sql="select * from item where name=?";
//				PreparedStatement psmt=conn.prepareStatement(sql);
//				psmt.setString(1, name);
//				int result=psmt.executeUpdate();
//				if(result==0) {
//					return true;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
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
//		return false;
//	}
	
	//식자재리스트
	public ArrayList<ItemDTO> allItem(){
		ArrayList<ItemDTO>ilist=new ArrayList<>();
		if(conn()) {
			try {
				String sql="select * from item";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					ItemDTO idto=new ItemDTO();
					idto.setNo(rs.getInt("no"));
					idto.setName(rs.getString("name"));
					idto.setPrice(rs.getInt("price"));
					idto.setQuantity(rs.getInt("qty"));
					ilist.add(idto);
				}
			} catch (Exception e) {
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
	//반품시 재고변경
	public void returnItem(int selNum,int qty) {
		if(conn()) {
			try {
				String sql="update nowitem set qty=qty-? where no=? ";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, qty);
				psmt.setInt(2, selNum);
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("반품되었습니다");
					conn.commit();
				}else {
					System.out.println("반품실패");
					conn.rollback();
				}
			} catch (Exception e) {
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
	//반품시트 등록
	public void addReturn(String mname,int selNum,int qty) {
		if(conn()) {
			try {
				int price=0;
				String item=null;
				String sql="select * from nowitem where no=? ";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, selNum);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					price=  rs.getInt("price");
					item=rs.getString("name");
				}
				sql="insert into return values(?,?,?,?)";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, mname);
				psmt.setString(2, item);
				psmt.setInt(3, qty);
				psmt.setInt(4, price);
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("반품시트 등록완료");
					conn.commit();
				}else {
					System.out.println("반품시트 등록실패");
					conn.rollback();
				}
				
			} catch (Exception e) {
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
	
	//판매시 재고변경
	public void salesItem(int selNum,int qty) {
		if(conn()) {
			try {
				String sql="update nowitem set qty=qty-? where no=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, qty);
				psmt.setInt(2, selNum);
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("판매완료");
					conn.commit();
				}else {
					System.out.println("판매실패");
					conn.rollback();
				}
				
			} catch (Exception e) {
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
	
	//판매시트 등록
	public void addRevenue(String mname,int selNum,int qty) {
		if(conn()) {
			try {
				int price=0;
				String item=null;
				String sql="select * from nowitem where no=? ";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, selNum);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					price= (int) ((int) rs.getInt("price")*qty*1.5);
					item=rs.getString("name");
				}
				sql="insert into revenue values(?,?,?,?)";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, mname);
				psmt.setString(2, item);
				psmt.setInt(3, qty);
				psmt.setInt(4, price);
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("판매시트 등록완료");
					conn.commit();
				}else {
					System.out.println("판매시트 등록실패");
					conn.rollback();
				}
				
			} catch (Exception e) {
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
	//수익확인
	public int inMoney() {
		if(conn()) {
			try {
				int total=0;
				String sql="select sum(price) from revenue";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					total+=rs.getInt("sum(price)");
				}
				sql="select sum(price) from return";
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				while(rs.next()) {
					total+=rs.getInt("sum(price)");
				}
				return total;
			} catch (Exception e) {
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
		return 0;
	}
	//발주비용확인
	public int outMoney() {
		if(conn()) {
			try {
				int total=0;
				String sql="select sum(price) from return";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					total=rs.getInt("sum(price)");
					return total;
				}
			} catch (Exception e) {
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
		return 0;
	}
}
