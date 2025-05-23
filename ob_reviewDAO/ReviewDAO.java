package ob_reviewDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ob_review.ReviewDTO;

public class ReviewDAO {
	private String username="system";
	private String password="11111111";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName="oracle.jdbc.driver.OracleDriver";
	private Connection conn=null;
	public static ReviewDAO rdao=null;
	private ReviewDTO rdto=null;
	private ReviewDAO() {
		init();
	}
	
	public static ReviewDAO getInstance() {
		if(rdao==null) {
			rdao=new ReviewDAO();
		}
		return rdao;
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
	//고객 리뷰달기
		public void review(ReviewDTO rdto) {
			if(conn()) {
				try {
					String sql="insert into review values (review_no.nextval,?,?,?)";
					PreparedStatement psmt=conn.prepareStatement(sql);
					psmt.setString(1,rdto.getName());
					psmt.setString(2, rdto.getContent());
					psmt.setInt(3, rdto.getStar());
					int result=psmt.executeUpdate();
					if(result!=0) {
						System.out.println("리뷰달기 성공");
						conn.commit();
					}else {
						System.out.println("리뷰달기 실패");
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

		public void menu() {
			Scanner in=new Scanner(System.in);
			System.out.println("이름을 입력하세요");
			String name=in.nextLine();
			System.out.println("리뷰를 입력하세요");
			String content=in.nextLine();
			System.out.println("별점을 입력하세요");
			int star=in.nextInt();
			in.nextLine();
			rdto=new ReviewDTO();
			rdto.setName(name);
			rdto.setContent(content);
			rdto.setStar(star);
			review(rdto);
		}

		public void showReview() {
			if(conn()) {
				try {
					String sql="select * from review";
					PreparedStatement psmt=conn.prepareStatement(sql);
					ResultSet rs=psmt.executeQuery();
					while(rs.next()) {
						ReviewDTO temp=new ReviewDTO();
						temp.setNo(rs.getInt("no"));
						temp.setName(rs.getString("name"));
						temp.setContent(rs.getString("content"));
						temp.setStar(rs.getInt("star"));
						System.out.println(temp.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
}
