package javaProject;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {
	UserReg ureg=null;
	ArrayList<UserReg> ulist=new ArrayList<>();
	boolean login=false;
	UserMain(){
		
	}
	//메인메뉴
	public void menu() {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 상품구매");
			System.out.println("4. 구매내역");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				addUser();
			}else if(selNum==2) {
				login();
			}else if(selNum==3) {
				bgoods();
			}else if(selNum==4) {
				blist();
			}else if(selNum==9876) {
				staffOnly();
			}
		}
	}
	//회원가입
	public void addUser(){
		ureg=new UserReg();
		Scanner in=new Scanner(System.in);
		System.out.println("새로 만들 아이디를 입력하세요");
		String uid=in.nextLine();
		int ck=chk(uid);
		if(ck==1) {
			ureg.setId(uid);
			System.out.println("이름을 입력하세요");
			String uname=in.nextLine();
			ureg.setName(uname);
			ulist.add(ureg);
			ureg=null;
		}else {
			System.out.println("이미 중복된 아이디가 있습니다.");
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
		if(ck==1) {
			System.out.println("비밀번호를 입력하세요");
			String pwd=in.nextLine();
			for(int i=0;i<ulist.size();i++) {
				if(ulist.get(i).getPwd().equals(pwd)) {
					System.out.println(ulist.get(i).getId()+"님 환영합니다");
					break;
				}
			}
			
		}else {
			System.out.println("등록된 회원이 아닙니다");
		}
	}
	//상품구매
	public void bgoods() {
		
	}
	//구매리스트
	public void blist() {
		
	}
	//직원전용(상품관리)
	public void staffOnly(){
		
	}
	
}
