package ob2_1_staff;

import java.util.ArrayList;
import java.util.Scanner;

import ob2_1_item.ItemDTO;
import ob2_1_item_dao.ItemDAO;
import ob2_1_staff_dao.StaffDAO;

public class Manager extends Staff {
	StaffDAO sdao=StaffDAO.getInstance();
	ItemDAO idao=ItemDAO.getInstance();
	
	public void orderItem() {
		showItem();
		Scanner in=new Scanner(System.in);
		System.out.println("발주할 품목을 선택하세요");
		int selNum=in.nextInt();
		in.nextLine();
		System.out.println("발주수량을 입력하세요");
		int qty=in.nextInt();
		in.nextLine();
		idao.orderItem(selNum,qty);
		idao.addOrder(this.getName(), selNum, qty);
	}
	public void returnItem() {
		showItem();
		Scanner in=new Scanner(System.in);
		System.out.println("반품할 품목을 선택하세요");
		int selNum=in.nextInt();
		in.nextLine();
		System.out.println("반품수량을 입력하세요");
		int qty=in.nextInt();
		in.nextLine();
		idao.returnItem(selNum,qty);
		idao.addReturn(this.getName(),selNum, qty);
	}
	public void showStaff() {
		ArrayList<Staff>slist=sdao.all();
		for(Staff temp:slist) {
			System.out.println(temp.toString());
		}
	}
	public void showItem() {
		ArrayList<ItemDTO>ilist=idao.allItem();
		for(ItemDTO temp:ilist) {
			System.out.println(temp.getNo()+"번: "+temp.toString());
		}
	}
	public void salesManage() {
		showItem();
		Scanner in=new Scanner(System.in);
		System.out.println("판매한 품목를 선택하세요");
		int selNum=in.nextInt();
		in.nextLine();
		System.out.println("판매수량을 입력하세요");
		int qty=in.nextInt();
		in.nextLine();
		idao.salesItem(selNum,qty);
		idao.addRevenue(this.getName(),selNum, qty);
	}
	
	
}
