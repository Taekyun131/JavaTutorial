package 수강신청;

import java.util.Scanner;

public class MainMenu {
	StudentM sm=null;
	ClassM cm=null;
	
	MainMenu() {
		if(sm==null) {
			sm=new StudentM();
		}
		if(cm==null) {
			cm=new ClassM();
			
		}
		menu();
	}
	
	private void menu() {
		while(true) {
			Scanner in=new Scanner(System.in);
			System.out.println("*****수강신청 프로그램*****");
			System.out.println("1. 학생 관리");
			System.out.println("2. 교과목 관리");
			System.out.println("3. 프로그램 종료");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				sm.cm=cm;
				sm.menu();
			}else if(selNum==2) {
				cm.menu();
			}else if(selNum==3) {
				break;
			}
		}
	}
	
}
