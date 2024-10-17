package ob2_login;

import java.util.Scanner;

import ob2_review_dao.ReviewDAO;
import ob2_staff.Manager;
import ob2_staff.Owner;
import ob2_staff.Staff;
import ob2_staff_dao.StaffDAO;

public class LoginMain {
	LoginStaff ls=null;
	LoginManager lm=null;
	LoginOwner lo=null;
	StaffDAO sdao=StaffDAO.getInstance();//싱글톤 디자인
	ReviewDAO rdao=ReviewDAO.getInstance();
	Staff s=null;
	public LoginMain(){
		init();
	}
	private void init() {
		if(ls==null) {
			ls=new LoginStaff();
		}
		if(lm==null) {
			lm=new LoginManager();
		}
		if(lo==null) {
			lo=new LoginOwner();
		}
	}
	public void menu() {
		while(true) {
			Scanner in=new Scanner(System.in);
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 직원 로그인");
			System.out.println("2. 매니저 로그인");
			System.out.println("3. 점주 로그인");
			System.out.println("4. 고객 리뷰달기");
			System.out.println("5. 프로그램 종료");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				loginS();
			}else if(selNum==2) {
				loginM();
			}else if(selNum==3) {
				loginO();
			}else if(selNum==4) {
				loginC();
			}else if(selNum==5) {
				break;
			}
		}
	}
	
	//고객 리뷰달기
	private void loginC() {
		rdao.menu();
	}
	//직원 로그인
	private void loginS() {
		Scanner in=new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id=in.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pwd=in.nextLine();
		Staff login=sdao.loginchk(id, pwd);
		if(login!=null) {
			System.out.println(login.getId()+"님 환영합니다.");
			ls.menu(login);
		}
		
	}
	//매니저 로그인
	private void loginM() {
		Scanner in=new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id=in.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pwd=in.nextLine();
		Manager login=sdao.loginMchk(id, pwd);
		if(login!=null) {
			System.out.println(login.getId()+"님 환영합니다.");
			lm.menu(login);
		}
	}
	//점주 로그인
	
	private void loginO() {
		Scanner in=new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id=in.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pwd=in.nextLine();
		Owner login=sdao.loginOchk(id, pwd);
		if(login!=null) {
			System.out.println(login.getId()+"님 환영합니다.");
			lo.menu(login);
		}
		
	}
	
}

