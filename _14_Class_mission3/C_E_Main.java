package _14_Class_mission3;

import java.util.Scanner;

public class C_E_Main {
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {
			System.out.println("*****고객&이벤트 관리 프로그램*****");
			System.out.println("번호를 선택하세요");
			System.out.println("1. 고객관리");
			System.out.println("2. 이벤트관리");
			System.out.println("3. 프로그램 종료");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				ClientMg cMg=new ClientMg();
			}else if(selNum==2) {
				EventMg eMg=new EventMg();
			}else if(selNum==3) {
				break;
			}
		}
	}

}
