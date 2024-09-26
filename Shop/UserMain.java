package Shop;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {
	
	UserReg ureg=null;
	GoodsMge gmge = null;
	UserReg login=null;
	ArrayList<UserReg> ulist=new ArrayList<>();
	
	UserMain(){
		if(ureg==null) {
			ureg=new UserReg();
		}
		if(gmge==null) {
			gmge=new GoodsMge();
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
				gmge.goodsMenu();
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
			if(pwd.equals(pwd2)) {
				ureg.setPwd(pwd);
				ulist.add(ureg);
			}else {
				System.out.println("비밀번호가 다릅니다");
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
		if(ck==- 1) {
			System.out.println("비밀번호를 입력하세요");
			String pwd=in.nextLine();
			for(int i=0;i<ulist.size();i++) {
				UserReg user=ulist.get(i);
				if(user.getPwd().equals(pwd)) {
					System.out.println(user.getId()+"님 환영합니다");
					login=user;
					loginMenu();
					break;
				}
			}
		}else {
			System.out.println("로그인 실패");
		}
	}
	
	public void loginMenu() {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("1. 상품구매");
			System.out.println("2. 구매내역");
			System.out.println("3. 로그아웃");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				bgoods();
			}else if(selNum==2) {
				blist();
			}else if(selNum==3) {
				break;
			}
		}
	}
	
	//상품구매
	public void bgoods() {
		for(int i=0; i< gmge.gList.size();i++) {
			gmge.gList.get(i).prt();
		}
		Scanner in=new Scanner(System.in);
		System.out.println("구매할 상품이름을 입력");
		String buy=in.nextLine();
		System.out.println("구매할 수량 입력");
		int buyNum=in.nextInt();
		in.nextLine();
		ureg.buyGoods(buy, buyNum);
		for(int i=0; i< gmge.gList.size();i++) {
			if(gmge.gList.get(i).goodsName.equals(buy)) {
				Goods newgoogs=new Goods();
				newgoogs.goodsName=buy;
				newgoogs.goodsNum=gmge.gList.get(i).goodsNum-buyNum;
				gmge.gList.set(i, newgoogs);
				
				if(newgoogs.goodsNum==0) {
					gmge.gList.remove(i);
				}
				
				
			}
		}
	}
	
	//구매리스트
	public void blist() {
		login.bprt();
		
	}
	


	
}
