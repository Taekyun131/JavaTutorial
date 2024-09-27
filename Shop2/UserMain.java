package Shop2;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {
	//클래스 의존관계에 따라 변수선언
	UserReg ureg=null;
	GoodsMge gmge = null;
	UserReg login=null;
	//회원가입한 유저를 저장할 arrayList
	ArrayList<UserReg> ulist=new ArrayList<>();
	
	UserMain(){
		//객체가 생성이 되지 않았으면 생성
		if(ureg==null) {
			ureg=new UserReg();
		}
		if(gmge==null) {
			gmge=new GoodsMge();
		}
		//메뉴 호출
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
				gmge.goodsMenu();			//관리자모드 접속시 상품관리 클래스의 상품메뉴 메소드 실행
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
					loginMenu();	//로그인 성공시 로그인 메뉴 호출
					break;
				}else {
					System.out.println("비밀번호가 일치하지 않습니다");
				}
			}
		}else {
			System.out.println("로그인 실패");
		}
	}
	
	//로그인 메뉴 
	public void loginMenu() {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("1. 상품구매");
			System.out.println("2. 구매내역");
			System.out.println("3. 충전하기");
			System.out.println("4. 잔액확인");
			System.out.println("5. 로그아웃");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				bgoods();
			}else if(selNum==2) {
				blist();
			}else if(selNum==3) {
				charge();
			}else if(selNum==4) {
				checkmoney();
			}else if(selNum==5) {
				break;
			}
		}
	}
	
	//상품구매
	public void bgoods() {
		
		for(int i=0; i< gmge.gList.size();i++) {
			gmge.gList.get(i).prt();
		}	//상품리스트 출력
		Scanner in=new Scanner(System.in);
		System.out.println("구매할 상품이름을 입력");
		String buy=in.nextLine();
		//상품리스트에서 입력한 상품명과 같은 상품을 스캔
		int idx=-1;
		if(gmge.gList.size()!=0) {
			for(int i=0;i<gmge.gList.size();i++) {
				if(gmge.gList.get(i).goodsName.equals(buy)) {
					idx=i;
				}
			}
		}
		//일치하는 상품이 있으면 구매진행
		//일치하지 않으면 구매불가
		if(idx==-1) {
			System.out.println("상품목록에 해당상품이 없습니다.");
		}else {
			System.out.println("구매할 수량 입력");
			int buyNum=in.nextInt();
			in.nextLine();
			int total=gmge.gList.get(idx).pay*buyNum;
			//해당하는 품목수량과 구매수량을 비교하여 구매가능여부확인
			if(gmge.gList.get(idx).getNum()>=buyNum) {
				//구매금액과 가지고 있는 금액을 비교하여 구매가능여부확인
				if(total<=login.money) {
					ureg.buyGoods(buy, buyNum);
					login.setMoney(gmge.gList.get(idx).pay,buyNum);
					gmge.gList.get(idx).goodsNum-=buyNum;
					System.out.println("총금액 "+total+"원");
					gmge.addSale(total);
				}else {
					System.out.println("잔액을 확인하세요");
				}
			}else {
				System.out.println("구매수량이 많습니다");
			}
//			for(int i=0; i< gmge.gList.size();i++) {
//				//남은 수량내에서 구매가능
//				if(gmge.gList.get(i).getNum()-buyNum>=0) {	
//					// 잔액없으면 구매불가
//					if(total<=login.money) {
//						ureg.buyGoods(buy, buyNum);
//						login.setMoney(gmge.gList.get(idx).pay,buyNum);
//						gmge.gList.get(idx).goodsNum-=buyNum;
//						System.out.println("총금액 "+total+"원");
//						gmge.addSale(total);
//						break;
//					}else {
//						System.out.println("잔액을 확인하세요");
//					}
//				}else {
//					System.out.println("구매수량이 너무 많습니다");
//				}
//				
//				if(gmge.gList.get(i).getNum()==0) {
//					gmge.gList.remove(i);
//				}
//			}
		}
	}
	
	//구매리스트
	public void blist() {
		login.bprt();
		System.out.println("잔액"+login.money+"원");
		
	}
	
	// 충전하기
	public void charge() {
		Scanner in=new Scanner(System.in);
		System.out.println("충전할 금액을 입력하세요");
		int tm=in.nextInt();
		in.nextLine();
		login.money+=tm;
		System.out.println(login.money);
	}
	public void checkmoney() {
		System.out.println(login.money+"원");
	}
	
}
