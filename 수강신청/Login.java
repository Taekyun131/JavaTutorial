package 수강신청;

import java.util.Scanner;

public class Login {
	Student user=null;
	ClassM cm=null;
	
	Login(){
		
	}
	public void menu() {
		while(true) {
			Scanner in=new Scanner(System.in);
			System.out.println("1. 수강신청");
			System.out.println("2. 신청리스트");
			System.out.println("3. 로그아웃");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				addClass();
			}else if(selNum==2){
				user.allClass();
			}else if(selNum==3) {
				break;
			}
		}
	}
	//수강신청
	private void addClass() {
		Scanner in=new Scanner(System.in);
		cm.showTitle();
		System.out.println("수강신청할 과목을 입력하세요");
		String ctitle=in.nextLine();
		int idx=-1;
		for(int i=0;i<cm.cList.size();i++) {
			if(cm.cList.get(i).getTitle().equals(ctitle)) {
				idx=i;
			}
		}
		if(idx==-1) {
			System.out.println("해당과목이 없습니다");
		}else {
			user.regClass(cm.cList.get(idx));
		}
		
	}
	
	//login 유저 
	public void setUser(Student s) {
		this.user=s;
	}
}
