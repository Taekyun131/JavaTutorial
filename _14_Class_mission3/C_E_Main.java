package _14_Class_mission3;

import java.util.Scanner;
public class C_E_Main {
	public static void main(String[] args) {
		ClientMg cMg=null;
		EventMg eMg=null;
		while(true) {
			System.out.println("*****고객&이벤트 관리 프로그램*****");
			System.out.println("번호를 선택하세요");
			System.out.println("1. 고객관리");
			System.out.println("2. 이벤트관리");
			System.out.println("3. 프로그램 종료");
			Scanner in=new Scanner(System.in);
			int selNum=in.nextInt();
			in.nextLine();
			
			if(selNum==1) {
				if(cMg==null) {
					cMg=new ClientMg();
				}else {
					
				}
			}else if(selNum==2) {
				if(eMg==null) {
					eMg=new EventMg();
				}else {
					
				}
			}else if(selNum==3) {
				break;
			}
		}
	}

}
