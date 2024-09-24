package _14_Class_mission3;

import java.util.Scanner;

public class ClientMg {
	ClientInfo [] cList=new ClientInfo[5];
//	EventReg [] eList=new EventReg[5];
	Scanner in=new Scanner(System.in);
	public ClientMg() {
			menu();
	}
	//메뉴
	public void menu() {
		while(true) {
			System.out.println("번호를 선택하세요");
			System.out.println("1. 고객등록");
			System.out.println("2. 정보보기");
			System.out.println("3. 수정하기");
			System.out.println("4. 아이디 삭제하기");
			System.out.println("5. 전체 고객명단보기");
			System.out.println("6. 돌아가기");
//		System.out.println("5. 이벤트 등록하기");
//		System.out.println("6. 이벤트 전체보기");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				add();
			}else if(selNum==2) {
				showInfo();
			}else if(selNum==3) {
				mod();
			}else if(selNum==4) {
				del();
//		}else if(selNum==5) {
//			addEvent();
//		}else if(selNum==6) {
//			showEvent();
			}else if(selNum==5) {
				allList();
			}else if(selNum==6){
				break;
			}
		}
	}
		
	//가입하기
	public void add() {
		ClientInfo cInfo=new ClientInfo();
		System.out.println("아이디를 입력하세요");
		String cid=in.nextLine();
		cInfo.setId(cid);
		System.out.println("이름을 입력하세요");
		String cname=in.nextLine();
		cInfo.setName(cname);
		for(int i=0;i<cList.length;i++) {
			if(cList[i]==null) {
				cList[i]=cInfo;
				break;
			}
		}
	}
	//정보보기
	public void showInfo() {
		System.out.println("확인할 고객의 아이디를 입력하세요");
		String sId=in.nextLine();
		for(int i=0;i<cList.length;i++) {
			if(cList[i]!=null) {
				if(cList[i].getId().equals(sId)) {
					cList[i].prt();
				}
			}
		}
	}
	//수정하기
	public void mod() {
		System.out.println("수정할 아이디를 입력하세요");
		String mId=in.nextLine();
		for(int i=0;i<cList.length;i++) {
			if(cList[i]!=null) {
				if(cList[i].getId().equals(mId)) {
					System.out.println("수정할 이름을 입력하세요");
					String mName=in.nextLine();
					cList[i].setName(mName);
				}
			}
		}
	}
	//삭제하기
	public void del() {
		System.out.println("삭제할 아이디를 입력하세요");
		String dId=in.nextLine();
		for(int i=0;i<cList.length;i++) {
			if(cList[i]!=null) {
				if(cList[i].getId().equals(dId)){
					cList[i]=null;
				}
			}
		}
		
	}
	//전체 고객명단
	public void allList() {
		for(int i=0;i<cList.length;i++) {
			if(cList[i]!=null) {
				cList[i].prt();
			}
		}
	}
//	//이벤트등록
//	public void addEvent() {
//		EventReg ereg=new EventReg();
//		System.out.println("등록할 이벤트 제목을 입력하세요");
//		String etitle=in.nextLine();
//		ereg.setTitle(etitle);
//		System.out.println("이벤트의 내용을 입력하세요");
//		String econtent=in.nextLine();
//		ereg.setContent(econtent);
//		for(int i=0;i<eList.length;i++) {
//			if(eList[i]==null) {
//				eList[i]=ereg;
//				break;
//			}
//		}
//		
//	}
//	//이벤트전체보기
//	public void showEvent() {
//		for(int i=0;i<eList.length;i++) {
//			if(eList[i]!=null) {
//				eList[i].prt();
//			}
//		}
//	}
}
