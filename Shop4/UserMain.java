package Shop4;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {
	//클래스 의존관계에 따라 변수선언
	UserReg loginUser=null;
	GoodsMge gmge=null;
	UserMain(){
	if(gmge==null) {
		gmge=new GoodsMge();
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
	//
	public void staffOnly() {
		gmge.goodsMenu();
		
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
			//해당하는 품목수량과 구매수량을 비교하여 구매여부확인
			if(gmge.gList.get(idx).getNum()>=buyNum) {
				if(total<=loginUser.money) {	// 잔액과 구매금액 비교해서 잔액부족시 구매불가
					loginUser.buyGoods(buy, buyNum);
					loginUser.setMoney(gmge.gList.get(idx).pay,buyNum);
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
		loginUser.bprt();
		System.out.println("잔액"+loginUser.money+"원");
		
	}
	
	// 충전하기
	public void charge() {
		Scanner in=new Scanner(System.in);
		System.out.println("충전할 금액을 입력하세요");
		int tm=in.nextInt();
		in.nextLine();
		loginUser.money+=tm;
		System.out.println(loginUser.money);
	}
	public void checkmoney() {
		System.out.println(loginUser.money+"원");
	}
	
}
