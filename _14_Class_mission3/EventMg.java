package _14_Class_mission3;

import java.util.Scanner;

public class EventMg {
	EventReg [] eList=new EventReg[5];
	Scanner in=new Scanner(System.in);
	public EventMg() {
		menu();
	}
	//메뉴
	public void menu() {
		while(true) {
			System.out.println("번호를 선택하세요");
			System.out.println("1. 이벤트 등록");
			System.out.println("2. 이벤트 전체보기");
			System.out.println("3. 돌아가기");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				addEvent();
			}else if(selNum==2) {
				showEvent();
			}else if(selNum==3){
				break;
			}
		}
	}
	//이벤트등록
	public void addEvent() {
		EventReg ereg=new EventReg();
		System.out.println("등록할 이벤트 제목을 입력하세요");
		String etitle=in.nextLine();
		ereg.setTitle(etitle);
		System.out.println("이벤트의 내용을 입력하세요");
		String econtent=in.nextLine();
		ereg.setContent(econtent);
		for(int i=0;i<eList.length;i++) {
			if(eList[i]==null) {
				eList[i]=ereg;
				break;
			}
		}
		
	}
	//이벤트전체보기
	public void showEvent() {
		for(int i=0;i<eList.length;i++) {
			if(eList[i]!=null) {
				eList[i].prt();
			}
		}
	}
		
	
}
