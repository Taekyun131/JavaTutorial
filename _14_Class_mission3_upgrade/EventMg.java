package _14_Class_mission3_upgrade;

import java.util.Scanner;

public class EventMg {
	EventReg[] eList=new EventReg[5];
	Scanner in=new Scanner(System.in);
	EventMg(){
		
	}
	public void menu() {
		while(true) {
			System.out.println("번호를 선택하세요");
			System.out.println("1. 이벤트 등록하기");
			System.out.println("2. 이벤트 전체보기");
			System.out.println("3. 돌아가기");
			int selNum=in.nextInt();
			in. nextLine();
			if(selNum==1) {
				addEvent();
			}else if(selNum==2) {
				allList();
			}else if(selNum==3) {
				break;
			}
			
		}
	}
	public void addEvent() {
		EventReg eReg=new EventReg();
		System.out.println("등록할 이벤트명을 입력하세요");
		String eTitle=in.nextLine();
		eReg.setTitle(eTitle);
		System.out.println("이벤트 내용을 입력하세요");
		String eContent=in.nextLine();
		eReg.setContent(eContent);
		for(int i=0;i<eList.length;i++) {
			if(eList[i]==null) {
				eList[i]=eReg;
				break;
			}
		}
		
	}
	public void allList() {
		for(int i=0;i<eList.length;i++) {
			if(eList[i]!=null) {
				eList[i].prt();
			}
		}
	}
}
