package Shop4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	UserReg ureg=null;
	UserReg login=null;
	UserMain umge=null;
	//회원가입한 유저를 저장할 arrayList
	ArrayList<UserReg> ulist=new ArrayList<>();
	Main(){
	//객체가 생성이 되지 않았으면 생성
		if((umge==null)) {
			umge=new UserMain();
		}
		menu();
	}
	//메인메뉴
	public void menu() {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				addUser();
			}else if(selNum==2) {
				login();
			}else if(selNum==9876) {		// 관리자모드 접속
				umge.staffOnly();		//관리자모드 접속시 상품관리 클래스의 상품메뉴 메소드 실행
			}
		}
	}
	//회원가입
	public void addUser(){
		ureg=new UserReg();
		Scanner in=new Scanner(System.in);
		System.out.println("새로 등록할 아이디를 입력하세요");
		String uid=in.nextLine();
		int ck=chk(uid);
		if(ck==1) {
			ureg.setId(uid);
			System.out.println("이름을 입력하세요");
			String uname=in.nextLine();
			ureg.setName(uname);
			System.out.println("비밀번호를 설정하세요");
			String pwd=in.nextLine();
			System.out.println("비밀번호를 한번 더 입력하세요");
			String pwd2=in.nextLine();
			if(pwd.equals(pwd2)) {		// 비밀번호 일치여부 확인하기
				ureg.setPwd(pwd);
				ulist.add(ureg);
				System.out.println("가입이 완료 되었습니다.");
			}else {
				System.out.println("비밀번호가 일치하지 않습니다");
			}
					
		}else {
			System.out.println("아이디가 중복되었습니다.");
		}
		
		
	}
	//아이디 중복체크
	public int chk(String uid) {
		for(int i=0;i<ulist.size();i++) {
			if(ulist.get(i).getId().equals(uid)) {
				return -1;
			}
		}
		return 1;
	}
	
	//로그인
	public void login() {
		Scanner in=new Scanner(System.in);
		System.out.println("로그인할 아이디를 입력하세요");
		String uid=in.nextLine();
		int ck=chk(uid);
		if(ck==-1) {
			System.out.println("비밀번호를 입력하세요");
			String pwd=in.nextLine();
			for(int i=0;i<ulist.size();i++) {
				UserReg user=ulist.get(i);
				if(user.getPwd().equals(pwd)) {
					System.out.println(user.getId()+"님 환영합니다");
					login=user;
					
					umge.loginUser=login;
					umge.loginMenu();	//로그인 성공시 로그인 메뉴 호출
					break;
				}else {
					System.out.println("비밀번호가 일치하지 않습니다");
				}
			}
		}else {
			System.out.println("해당 아이디가 없습니다.");
		}
	}
	

}
