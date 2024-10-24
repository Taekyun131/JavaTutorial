package ob2_1_item_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ob2_1_info.Info;
import ob2_1_item.ItemDTO;

public class ItemDAO extends Info {
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
	
	//발주하면 현재재고 수량 증가
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
	//발주시 comitem테이블 수량변경
	public void modCom(int selNum,int qty) {
		if(conn()) {
			try {
				String sql="update comitem set qty=qty-? where no=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, qty);
				psmt.setInt(2, selNum);
				int result=psmt.executeUpdate();
				if(result!=0) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (Exception e) {
				// TODO: handle exception
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
				sql="insert into orderitem values(?,?,?,?,sysdate)";
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

	
	//식자재리스트
	public ArrayList<ItemDTO> allItem(){
		ArrayList<ItemDTO>ilist=new ArrayList<>();
		if(conn()) {
			try {
				String sql="select * from nowitem";
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
				sql="insert into return values(?,?,?,?,sysdate)";
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
	//반품시 comitem 재고변경
	public void comReturn(int selNum,int qty) {
		if(conn()) {
			try {
				String sql="update comitem set qty=qty+? where no=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, qty);
				psmt.setInt(2, selNum);
				int result=psmt.executeUpdate();
				if(result!=0) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
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
				sql="insert into revenue values(?,?,?,?,sysdate)";
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
	//판매시트금액
	public int salesMoney() {
		if(conn()) {
			try {
				int total=0;
				String sql="select sum(price*qty) as sum from revenue group by item";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					total+=rs.getInt("sum");
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
	//반품시트 금액
	public int returnMoney() {
		if(conn()) {
			try {
				int total=0;
				String sql="select sum(price*qty) as sum from return group by item";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					total+=rs.getInt("sum");
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
	public int orderMoney() {
		if(conn()) {
			try {
				int total=0;
				String sql="select sum(price*qty) as sum from orderitem group by item";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					total+=rs.getInt("sum");
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
	//발주시트
	public ArrayList<ItemDTO> chkOrder(){
		ArrayList<ItemDTO>ilist=new ArrayList<>();
		if(conn()) {
			try {
				String sql="select * from orderitem";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					ItemDTO temp=new ItemDTO();
					temp.setMname(rs.getString("mname"));
					temp.setName(rs.getString("item"));
					temp.setPrice(rs.getInt("price"));
					temp.setQuantity(rs.getInt("qty"));
					temp.setIntime(rs.getString("indate"));
					ilist.add(temp);
				}
				return ilist;
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
		return null;
	}
	//반품시트
		public ArrayList<ItemDTO> chkReturn(){
			ArrayList<ItemDTO>ilist=new ArrayList<>();
			if(conn()) {
				try {
					String sql="select * from return";
					PreparedStatement psmt=conn.prepareStatement(sql);
					ResultSet rs=psmt.executeQuery();
					while(rs.next()) {
						ItemDTO temp=new ItemDTO();
						temp.setMname(rs.getString("mname"));
						temp.setName(rs.getString("item"));
						temp.setPrice(rs.getInt("price"));
						temp.setQuantity(rs.getInt("qty"));
						temp.setIntime(rs.getString("indate"));
						ilist.add(temp);
					}
					return ilist;
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
			return null;
		}
		//판매시트
		public ArrayList<ItemDTO> chkSales(){
			ArrayList<ItemDTO>ilist=new ArrayList<>();
			if(conn()) {
				try {
					String sql="select * from revenue";
					PreparedStatement psmt=conn.prepareStatement(sql);
					ResultSet rs=psmt.executeQuery();
					while(rs.next()) {
						ItemDTO temp=new ItemDTO();
						temp.setMname(rs.getString("mname"));
						temp.setName(rs.getString("item"));
						temp.setPrice(rs.getInt("price"));
						temp.setQuantity(rs.getInt("qty"));
						temp.setIntime(rs.getString("indate"));
						ilist.add(temp);
					}
					return ilist;
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
			return null;
		}
	
}
