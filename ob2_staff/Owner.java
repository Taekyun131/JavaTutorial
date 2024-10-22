package ob2_staff;

import java.util.ArrayList;
import java.util.Scanner;

import ob2_item_dao.ItemDAO;
import ob2_review_dao.ReviewDAO;
import ob2_review_dto.ReviewDTO;

public class Owner extends Manager {
	public static Owner o=null;
	ItemDAO idao=ItemDAO.getInstance();
	
	ReviewDAO rdao=ReviewDAO.getInstance();
	
	
	//직원입사
	public void addStaff() {
		Scanner in=new Scanner(System.in);
		System.out.println("직원의 이름을 입력하세요");
		String name=in.nextLine();
		System.out.println("직원의 아이디를 입력하세요");
		String id=in.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pwd=in.nextLine();
		System.out.println("직급을 입력하세요(사원,매니저)");
		String rank=in.nextLine();
		Staff temp=new Staff();
		temp.setId(id);
		temp.setPwd(pwd);
		temp.setName(name);
		temp.setRank(rank);
		super.sdao.add(temp);
	}
	//직원퇴사
	public void delStaff() {
		Scanner in=new Scanner(System.in);
		System.out.println("퇴사한 직원의 이름을 입력하세요");
		String name=in.nextLine();
		System.out.println("아이디를 입력하세요");
		String id=in.nextLine();
		super.sdao.del(name,id);
	}
	//매출보기
	public void showSales() {
		int totalIn=idao.salesMoney()+idao.returnMoney();
		int totalOut=idao.orderMoney();
		System.out.println("총 금액: "+(totalIn-totalOut));
	}
	//리뷰확인
	public void chkReview() {
		ArrayList<ReviewDTO>rlist=rdao.showReview();
		for(ReviewDTO temp:rlist) {
			System.out.println(temp.toString());
		}
		
	}
}
