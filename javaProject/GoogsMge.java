package javaProject;

import java.util.ArrayList;
import java.util.Scanner;

// 관리자모드로 상품 관리하기 
public class GoogsMge {
	Scanner in=new Scanner(System.in);
	ArrayList<Googs> gList=new ArrayList<>();  // 등록된 상품리스트
	
	public GoogsMge() { 
		int selNum=0;
		while(true) {
			System.out.println("메뉴선택");
			googsMenu();
			selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				googsAdd();
			}else if(selNum==2) {
				googsMod();
			}else if(selNum==3) {
				googsDel();
			}else if(selNum==4) {
				googsList();
			}else if(selNum==5) {
				break;
			}
		}
		
		
	}
	
	public void googsMenu() {
		System.out.println("1. 등록");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 조회");
		System.out.println("5. 종료");
	}
	
	public void googsAdd() {	// 상품등록하기
		Googs temp=new Googs();
		System.out.println("상품명 입력");
		temp.googsName = in.nextLine();
		System.out.println("입고된 수량 입력");
		temp.googsNum = in.nextInt();
		in.nextLine();
		gList.add(temp);
		
	}
	
	public void googsMod() {	// 상품수정
		System.out.println("상품명 입력");
		String temp=in.nextLine();
		boolean flag= true;  // 검색한 상품이 없을수 있으니 변수하나 만들어주고
		for(int i = 0; i < gList.size(); i++) {
			if(gList.get(i).googsName.equals(temp)) {
				Googs newGoogs=new Googs();
				System.out.println("변경할 상품명 입력");
				newGoogs.googsName=in.nextLine();
				System.out.println("변경할 수량 입력");
				newGoogs.googsNum=in.nextInt();
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
	
	public void googsDel() {	// 상품삭제
		System.out.println("상품명 입력");
		String temp=in.nextLine();
		boolean flag= true;  // 
		for(int i = 0; i < gList.size(); i++) {
			if(gList.get(i).googsName.equals(temp)) {
				gList.remove(i);
				flag=false;			//  수정했다면 false 로 바꿔주기
				break; 		//for 종료해주기
			}
		}
		if(flag) {		// (flag=true)라면 바뀐게 없는거니까 포문 끝나고 확인해서 요러케
			System.out.println("등록된 상품이 없습니다.");
		}
		
	}
	
	public void googsList() {	// 상품전체 리스트
		for(int i=0;i<gList.size();i++) {
			gList.get(i).prt();
		}
	
	}
	
	
	
}
