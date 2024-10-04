package 수강신청_answer;

import java.util.ArrayList;
import java.util.Scanner;

public class PartMge {
	public ArrayList<Part> plist=new ArrayList<>();
	
	public void menu() {
		 while(true) {
			 Scanner in=new Scanner(System.in);
			 System.out.println("1. 등록");
			 System.out.println("2. 전체보기");
			 int selNum=in.nextInt();
			 if(selNum==1) {
				 add();
			 }else if(selNum==2) {
				 list();
			 }else  {
				 break;
			 }
		 }
	}
	
	public ArrayList<Part> getPlist() {
		return plist;
	}


	private void add() {
		 Scanner in=new Scanner(System.in);
		 Part newTemp=new Part();
		 System.out.println("과목명 입력");
		 String partname=in.nextLine();
		 newTemp.setClassName(partname);;
		 plist.add(newTemp);
	 }
	public void list() {
		for(int i=0;i<plist.size();i++) {
			plist.get(i).prt();
		}
	}
}
