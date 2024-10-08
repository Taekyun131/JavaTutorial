package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberADM {
	//ojdb6 개발하는 순서
	//1. 드라이버로드(1번만)
	//2. CRUD 작업이 있을 때마다 다음과정을 생각
	//	2-1. 커넥션 가져오기(Oracle에서 제공하는 자원)
	//		오라클에서 작업하기 전에 커넥션 자원을 획득해야 한다.
	//		커넥션 자원은 한정적이기에 쓰고나면 반납하는 것이 좋다.(2-7)
	//		오라클은 커넥션자원을 유한으로 만들어놓고 공유해서 사용하도록 한다.
	//	2-2. 쿼리문 만들기
	//	2-3. 쿼리문 완성하기(Mapping)
	//	2-4. 쿼리문 전송하여 오라클에서 실행
	//	2-5. 오라클에서 리턴값 전송
	//	2-6. 자바에서 2-5에서 받은 리턴값 처리
	//	2-7. 커넥션 자원 반납(중요)>>반납하지 않으면 idle time이 길이져 성능저하의 원인이 될 수 있다.
	MemberADM(){
		//드라이버 로드는 1번만 하면 되므로 생성자에서 작업
		init();
		insert();
	}
	
	private void init() {
		//오라클 드라이버 로드 코딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void insert(){
		//DTO객체를 생성.. Oracle에 저장
		MemberDTO m=new MemberDTO();
		m.setId("a");
		m.setName("kim");
		m.setAge(27);
		//2-1. 커넥션 자원 가져오기
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","system","11111111");
			System.out.println("커넥션 자원 획득 성공");
			String sql="insert into memberone values(?,?,?,default)";
			//쿼리문을 커넥션을 통해서 연결
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//매핑
			pstmt.setString(1,m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setInt(3, m.getAge());
			//실행후 리턴값 가져오기
			int result=pstmt.executeUpdate();
			if(result==0) {
				conn.rollback();
			}else {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(Exception e2) {
					
				}
			}
		}
		
	}
}
