package ob_login;

import java.util.Scanner;

import ob_staff.Owner;

public class LoginOwner {
	Owner o=null;
	public void menu(){
		Scanner in=new Scanner(System.in);
		System.out.println("메뉴를 선택하세요");
		while(true) {
			System.out.println("1. 직원채용");
			System.out.println("2. 사직원 작성");
			System.out.println("3. 매출실적 확인");
			System.out.println("4. 로그아웃");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				o.addStaff();
			}else if(selNum==2) {
				o.delStaff();
			}else if(selNum==3) {
				o.showSales();
			}else if(selNum==4) {
				break;
			}
	
		}
	}

	
}
