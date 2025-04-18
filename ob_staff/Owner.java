package ob_staff;

import java.util.Scanner;

import ob_item_dao.ItemDAO;
import ob_reviewDAO.ReviewDAO;

public class Owner extends Manager {
	public static Owner o=null;
	ItemDAO idao=ItemDAO.getInstance();
	
	private Owner() {
		
	}
	ReviewDAO rdao=ReviewDAO.getInstance();
	public static Owner getInstance() {
		if(o==null) {
			o=new Owner();
		}
		return o;
	}
	
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
		int totalIn=idao.inMoney();
		int totalOut=idao.outMoney();
		System.out.println("총 금액: "+(totalIn-totalOut));
	}
	//리뷰확인
	public void chkReview() {
		rdao.showReview();
	}
}
