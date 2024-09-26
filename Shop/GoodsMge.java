package Shop;

import java.util.ArrayList;
import java.util.Scanner;

// 관리자모드로 상품 관리하기 
public class GoodsMge {
	Scanner in=new Scanner(System.in);
	ArrayList<Goods> gList=new ArrayList<>();  // 등록된 상품리스트
	
	public GoodsMge() { 
	
		
	}
	
	public void goodsMenu() {
		
		while(true) {
			System.out.println("메뉴선택");
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("4. 조회");
			System.out.println("5. 메인메뉴");
			int selNum=0;
			selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				goodsAdd();
			}else if(selNum==2) {
				goodsMod();
			}else if(selNum==3) {
				goodsDel();
			}else if(selNum==4) {
				goodsList();
			}else if(selNum==5) {
				break;
			}
		}
		
		
	}
	
	public void goodsAdd() {	// 상품등록하기
		Goods temp=new Goods();
		System.out.println("상품명 입력");
		temp.goodsName = in.nextLine();
		System.out.println("입고된 수량 입력");
		temp.goodsNum = in.nextInt();
		in.nextLine();
		gList.add(temp);
	
		
	}
	
	public void goodsMod() {	// 상품수정
		System.out.println("상품명 입력");
		String temp=in.nextLine();
		boolean flag= true;  // 검색한 상품이 없을수 있으니 변수하나 만들어주고
		for(int i = 0; i < gList.size(); i++) {
			if(gList.get(i).goodsName.equals(temp)) {
				Goods newGoogs=new Goods();
				System.out.println("변경할 상품명 입력");
				newGoogs.goodsName=in.nextLine();
				System.out.println("변경할 수량 입력");
				newGoogs.goodsNum=in.nextInt();
				in.nextLine();
				gList.set(i,newGoogs);
				flag=false;			//  수정했다면 false 로 바꿔주기
				break; 		//for 종료해주기
			}
		}
		if(flag) {		// (flag=true)라면 바뀐게 없는거니까 포문 끝나고 확인해서 요러케
			System.out.println("등록된 상품이 없습니다.");
		}
	}
	
	public void goodsDel() {	// 상품삭제
		System.out.println("상품명 입력");
		String temp=in.nextLine();
		boolean flag= true;  // 
		for(int i = 0; i < gList.size(); i++) {
			if(gList.get(i).goodsName.equals(temp)) {
				gList.remove(i);
				flag=false;			//  수정했다면 false 로 바꿔주기
				break; 		//for 종료해주기
			}
		}
		if(flag) {		// (flag=true)라면 바뀐게 없는거니까 포문 끝나고 확인해서 요러케
			System.out.println("등록된 상품이 없습니다.");
		}
		
	}
	
	public void goodsList() {	// 상품전체 리스트
		for(int i=0;i<gList.size();i++) {
			gList.get(i).prt();
		}
	
	}
	
	
	
}
