package ob2_1_review_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ob2_1_info.Info;
import ob2_1_review_dto.ReviewDTO;

public class ReviewDAO extends Info {
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
	
	//고객 리뷰달기
	public void review(ReviewDTO rdto) {
		if(conn()) {
			try {
				String sql="insert into review values (review_no.nextval,?,?,?,sysdate,?)";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1,rdto.getName());
				psmt.setString(2, rdto.getContent());
				psmt.setInt(3, rdto.getStar());
				psmt.setString(4,rdto.getVdate() );
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
	//리뷰메뉴
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
	//리뷰보기
	public ArrayList<ReviewDTO> showReview() {
		ArrayList<ReviewDTO>rlist=new ArrayList<>();
		if(conn()) {
			try {
				String sql="select * from review order by no";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					ReviewDTO temp=new ReviewDTO();
					temp.setNo(rs.getInt("no"));
					temp.setName(rs.getString("name"));
					temp.setContent(rs.getString("content"));
					temp.setStar(rs.getInt("star"));
					temp.setVdate(rs.getString("vdate").substring(0,11));
					rlist.add(temp);
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return rlist;
	}
	//평점계산
	public float avgStar() {
		float avg=0;
		if(conn()) {
			try {
				String sql="select round(avg(star),1) as avg from review";
				PreparedStatement psmt=conn.prepareStatement(sql);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					avg=rs.getFloat("avg");
				}
				return avg;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	//리뷰 삭제
	public void delReview(int idx) {
		if(conn()) {
			try {
				String sql="delete review where no=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setInt(1, idx);
				int result=psmt.executeUpdate();
				if(result!=0) {
					System.out.println("삭제되었습니다.");
					conn.commit();
				}else {
					System.out.println("삭제실패");
					conn.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
