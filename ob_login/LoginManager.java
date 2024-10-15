package ob_login;

import java.util.Scanner;

import ob_staff.Manager;

public class LoginManager {
	
	Manager m=null;

	public void menu(){
		while(true) {
			Scanner in=new Scanner(System.in);
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 판매관리");
			System.out.println("2. 발주");
			System.out.println("3. 식자재 현황");
			System.out.println("4. 전체직원 보기");
			System.out.println("5. 로그아웃");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				
			}else if(selNum==2) {
				m.orderItem();
			}else if(selNum==3) {
				
			}else if(selNum==4) {
				m.showStaff();
			}else if(selNum==5) {
				break;
			}
		}
	}
}
