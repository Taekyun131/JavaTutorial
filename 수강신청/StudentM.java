package 수강신청;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentM {
	Student s=null;
	Login user=null;
	ArrayList <Student> sList=new ArrayList<>();
	ClassM cm=null;
	StudentM(){
		if(user==null) {
			user=new Login();
			
		}
	}
	public void menu() {
		while(true) {
			Scanner in=new Scanner(System.in);
			System.out.println("1. 학생등록");
			System.out.println("2. 로그인");
			System.out.println("3. 이름검색");
			System.out.println("4. 학생 전체보기");
			System.out.println("5. 메인메뉴");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				add();
			}else if(selNum==2) {
				login();
			}else if(selNum==3) {
				search();
			}else if(selNum==4) {
				allStudent();
			}else if(selNum==5) {
				break;
			}

		}
	}
	//학생등록
	private void add() {
		if(sList.size()==10) {
			System.out.println("더이상 등록할 수 없습니다");
		}else {
			Scanner in=new Scanner(System.in);
			System.out.println("아이디를 입력하세요");
			String sid=in.nextLine();
			if(idCheck(sid)==-1||sList.size()==0) {
				s=new Student();
				s.setId(sid);
				System.out.println("이름을 입력하세요");
				String sname=in.nextLine();
				s.setName(sname);
				System.out.println("전화번호를 입력하세요");
				String spn=in.nextLine();
				s.setPn(spn);
				System.out.println("학년을 입력하세요");
				int sgrade=in.nextInt();
				in.nextLine();
				s.setGrade(sgrade);
				System.out.println("비밀번호를 입력하세요");
				String spwd=in.nextLine();
				s.setPwd(spwd);
				sList.add(s);
				System.out.println("등록이 완료되었습니다.");
			}else {
				System.out.println("중복된 아이디가 있습니다.");
			}
		}
		
	}
	
	//아이디 중복체크
	private int idCheck(String sid) {
		for(int i=0;i<sList.size();i++) {
			if(sList.get(i).getId().equals(sid)) {
				return i;
			}
		}
		return -1;
		
	}

	//로그인하기
	private void login() {
		Scanner in=new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String sid=in.nextLine();
		int temp=idCheck(sid);
		if(temp==-1) {
			System.out.println("등록된 아이디가 없습니다");
		}else {
			System.out.println("비밀번호를 입력하세요");
			String spwd=in.nextLine();
			if(sList.get(temp).getPwd().equals(spwd)) {
				user.setUser(sList.get(temp));
				user.cm=cm;
				user.menu();
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		
		}
			
		
				
				
		
	}
	//이름으로 등록된 학생검색
	private void search() {
		Scanner in=new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요");
		String sname=in.nextLine();
		int idx=-1;
		for(int i=0;i<sList.size();i++) {
			if(sList.get(i).getName().equals(sname)) {
				idx=i;
			}
		}
		if(idx==-1) {
			System.out.println("등록된 학생이 없습니다.");
		}else {
			sList.get(idx).prt();
		}
		
	}
	
	//학생 전체보기
	private void allStudent() {
		for(int i=0;i<sList.size();i++) {
			System.out.println(sList.get(i).getName());
		}
	}
	
	//cm
		public ClassM setCm() {
			return cm;
		}
	
}
