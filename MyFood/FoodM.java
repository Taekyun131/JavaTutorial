package MyFood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FoodM {
	FoodDTO f=null;
	FoodM(){
		init();
		menu();
	}
	private void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("드라이버 로드 성공");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void menu() {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("***My Food***");
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 음식 추가");
			System.out.println("2. 음식 삭제");
			System.out.println("3. 음식 수정");
			System.out.println("4. 음식 전체보기");
			System.out.println("5. 프로그램 종료");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				add();
			}else if(selNum==2) {
				delete();
			}else if(selNum==3) {
				modify();
			}else if(selNum==4) {
				all();
			}else if(selNum==5) {
				break;
			}
			
		}
	}
	private void all() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","system","11111111");
			String sql="select * from myfood";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet result=pstmt.executeQuery();//객체를 리턴
			while(result.next()) {//next(): boolean//첫번째 행부터 검색, 마지막 행에서 false 리턴
				System.out.println("음식이름: "+result.getString(1));
				System.out.println("좋아하는 정도: "+result.getInt(3));
				System.out.println();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch (Exception e) {
					
				}
			}
		}
			
		
	}
	private void modify() {
		Scanner in=new Scanner(System.in);
		System.out.println("수정할 음식을 선택하세요");
		String fname=in.nextLine();
		System.out.println("좋아하는 정도를 입력하세요(1~10)");
		int flevel=in.nextInt();
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","system","11111111");
			String sql="update myfood set lv=? where name=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, flevel);
			pstmt.setString(2, fname);
			int result=pstmt.executeUpdate();
			if(result==0) {
				conn.rollback();
			}else {
				conn.commit();
				System.out.println("수정되었습니다.");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch (Exception e) {
					
				}
			}
		}
		
	}
	private void delete() {
		Scanner in=new Scanner(System.in);
		System.out.println("삭제할 음식을 입력하세요");
		String fname=in.nextLine();
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","system","11111111");
			String sql="delete from myfood where name=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, fname);
			int result=pstmt.executeUpdate();
			if(result==0) {
				conn.rollback();
			}else {
				conn.commit();
				System.out.println("삭제되었습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch (Exception e) {
					
				}
			}
		}
		
	}
	private void add() {
		Scanner in=new Scanner(System.in);
		f=new FoodDTO();
		System.out.println("등록할 음식을 입력하세요");
		String fname=in.nextLine();
		f.setName(fname);
		System.out.println("좋아하는 정도를 입력하세요(1~10)");
		int flevel=in.nextInt();
		in.nextLine();
		f.setLikeLevel(flevel);
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","system","11111111");
//			System.out.println("커넥션 자원 획득 성공");
			String sql="insert into myfood values(?,default,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getName());
			pstmt.setInt(2, f.getLikeLevel());
			int result=pstmt.executeUpdate();
			if(result==0) {
				conn.rollback();
			}else {
				System.out.println("등록되었습니다.");
				conn.commit();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch (Exception e2) {
					
				}
			}
		}
		
	}
}
