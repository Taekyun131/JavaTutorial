package _14_Class_mission3_upgrade;

import java.util.Scanner;

public class ClientMg {
	ClientInfo []cList=new ClientInfo[5];
	Scanner in=new Scanner(System.in);
	
	ClientMg(){
//		menu();
	}
	public void menu() {
		while(true) {
			System.out.println("번호를 선택하세요");
			System.out.println("1. 고객등록");
			System.out.println("2. 고객정보확인");
			System.out.println("3. 고객삭제");
			System.out.println("4. 정보수정");
			System.out.println("5. 전체고객명단");
			System.out.println("6. 돌아가기");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				add();
			}else if(selNum==2) {
				showInfo();
			}else if(selNum==3) {
				del();
			}else if(selNum==4) {
				mod();
			}else if(selNum==5) {
				allList();
			}else if(selNum==6) {
				break;
			}
		}
	}
	public boolean rpt(String cId) {
		for(int i=0;i<cList.length;i++) {
			if(cList[i]!=null) {
				if(cList[i].getId().equals(cId)) {
					return false;
					//return에는 호출위치에 값반환+break기능
				}
			}
		}
		return true;
	}
	
	public void add() {
		ClientInfo cInfo=new ClientInfo();
		System.out.println("아이디를 입력하세요");
		String cId=in.nextLine();
		if(rpt(cId)) {
			cInfo.setId(cId);
			System.out.println("이름을 입력하세요");
			String cName=in.nextLine();
			cInfo.setName(cName);
			for(int i=0;i<cList.length;i++) {
				if(cList[i]==null) {
					cList[i]=cInfo;
					break;
				}
			}
		}else {
			System.out.println("중복된 아이디가 있습니다.");
		}
	}
	public void showInfo() {
		System.out.println("조회할 아이디를 입력하세요");
		String cId=in.nextLine();
		for(int i=0;i<cList.length;i++) {
			if(cList[i]!=null) {
				if(cList[i].getId().equals(cId)) {
					cList[i].prt();
				}
			}
		}
	}
	public void del() {
		System.out.println("삭제할 아이디를 입력하세요");
		String cId=in.nextLine();
		for(int i=0;i<cList.length;i++) {
			if(cList[i]!=null) {
				if(cList[i].getId().equals(cId)) {
					cList[i]=null;
				}
			}
		}
	}
	public void mod() {
		System.out.println("수정할 아이디를 입력하세요");
		String cId=in.nextLine();
		for(int i=0;i<cList.length;i++) {
			if(cList[i].getId().equals(cId)) {
				System.out.println("수정할 이름을 입력하세요");
				String cName=in.nextLine();
				cList[i].setName(cName);
			}
		}
	}
	public void allList() {
		for(int i=0;i<cList.length;i++) {
			if(cList[i]!=null) {
				cList[i].prt();
			}
		}
	}
}
