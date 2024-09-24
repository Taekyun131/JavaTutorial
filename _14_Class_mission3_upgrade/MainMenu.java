package _14_Class_mission3_upgrade;

import java.util.Scanner;

public class MainMenu {
	ClientMg cMg=null;
	EventMg eMg=null;
	MainMenu() {
		// 초기화 작업할 때 많이 사용
		// 초기화 작업은 멤버변수의 값을 셋팅하는 느낌
		// 예) 데이터베이스에서 값을 가져와서 초기값 결정
		// 메뉴는 초기화 작업이라고 보기 어렵다
		// 별도로 메서드 처리 하겠다.
		if(cMg==null) {
			cMg=new ClientMg();
		}
		if(eMg==null) {
			eMg=new EventMg();
		}
		menu();
	}
	public void menu() {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("*****고객&이벤트관리 프로그램");
			System.out.println("번호를 선택하세요");
			System.out.println("1. 고객관리");
			System.out.println("2. 이벤트관리");
			System.out.println("3. 프로그램 종료");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				cMg.menu();
			}else if(selNum==2) {
				eMg.menu();
			}else if(selNum==3) {
				break;
			}
		}
	}
}
