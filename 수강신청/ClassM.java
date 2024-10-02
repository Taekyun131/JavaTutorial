package 수강신청;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassM {
	Class c=null;
	Login user=null;
	ArrayList <Class> cList=new ArrayList<>();
	ClassM(){
		
	}
	public void menu() {
		while(true) {
			Scanner in=new Scanner(System.in);
			System.out.println("1. 교과 등록");
			System.out.println("2. 모든 과목보기");
			System.out.println("3. 메인메뉴");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				add();
			}else if(selNum==2) {
				showTitle();
			}else if(selNum==3) {
				break;
			}
		}
	}
	//교과 등록하기
	private void add() {
		Scanner in=new Scanner(System.in);
		c=new Class();
		System.out.println("등록할 교과목을 입력하세요");
		String ctitle=in.nextLine();
		System.out.println("강의실을 입력하세요");
		String croom=in.nextLine();
		System.out.println("담당교수를 입력하세요");
		String cprof=in.nextLine();
		c.setTitle(ctitle);
		c.setRoom(croom);
		c.setProf(cprof);
		cList.add(c);
	}
	//모든 교과목 보기
		public void showTitle(){
			for(int i=0;i<cList.size();i++) {
				cList.get(i).prt();
			}
		}
}
