package ob_item_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ob_item.ItemDTO;

public class ItemDAO {
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
	public void orderItem() {
		if(conn()) {
			try {
				String sql="insert into item values(?,?,?)";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, idto.getName());
				psmt.setInt(2, idto.getPrice());
				psmt.setInt(3, idto.getQuantity());
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
			}
		}
	}
	public void returnItem() {
		if(conn()) {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
