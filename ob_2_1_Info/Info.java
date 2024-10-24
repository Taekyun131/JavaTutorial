package ob_2_1_Info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Info {
	protected String username="system";
	protected String password="11111111";
	protected String url="jdbc:oracle:thin:@localhost:1521:orcl";
	protected String driverName="oracle.jdbc.driver.OracleDriver";
	protected Connection conn=null;
	
	protected void init() {//드라이버 로드
		try {
			Class.forName(driverName);
			System.out.println("오라클 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected boolean conn() {//커넥션 가져오는 공통 코드를 메서드로 정의
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
}
