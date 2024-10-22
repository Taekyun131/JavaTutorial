package ob2_1_login;

import java.util.Scanner;

import ob2_1_item_dao.ItemDAO;
import ob2_1_staff.Manager;

public class LoginManager {
	
	Manager m=null;
	ItemDAO idao=ItemDAO.getInstance();
	public void menu(Manager m){
		this.m=m;
		while(true) {
			Scanner in=new Scanner(System.in);
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 판매관리");
			System.out.println("2. 발주하기");
			System.out.println("3. 반품하기");
			System.out.println("4. 식자재 현황");
			System.out.println("5. 전체직원 보기");
			System.out.println("6. 로그아웃");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				m.salesManage();
			}else if(selNum==2) {
				m.orderItem();
			}else if(selNum==3) {
				m.returnItem();
			}else if(selNum==4) {
				m.showItem();
			}else if(selNum==5) {
				m.showStaff();
			}else if(selNum==6) {
				break;
			}
		}
	}
}
