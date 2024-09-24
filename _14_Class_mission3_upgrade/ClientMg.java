package _14_Class_mission3_upgrade;

import java.util.Scanner;

public class ClientMg {
	ClientInfo []cList=new ClientInfo[5];
	
	ClientMg(){
		menu();
	}
	public void menu() {
		while(true) {
			System.out.println("번호를 선택하세요");
			System.out.println("1. 고객등록");
			System.out.println("2. 고객정보확인");
			System.out.println("3. 고객삭제");
			System.out.println("4. 전체고객명단");
			System.out.println("5. 돌아가기");
			Scanner in=new Scanner(System.in);
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				add();
			}else if(selNum==2) {
				showInfo();
			}else if(selNum==3) {
				del();
			}else if(selNum==4) {
				allList();
			}else if(selNum==5) {
				break;
			}
		}
	}
	public void add() {
		
	}
	public void showInfo() {
		
	}
	public void del() {
		
	}
	public void allList() {
		
	}
}
