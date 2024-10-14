package ob_login;

import java.util.Scanner;

public class LoginMain {
	LoginManager lm=null;
	LoginOwner lo=null;
	public LoginMain(){
		if(lm==null) {
			lm=new LoginManager();
		}
		if(lo==null) {
			lo=new LoginOwner();
		}
	}
	public void menu() {
		while(true) {
			Scanner in=new Scanner(System.in);
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 로그인");
//			System.out.println("2. 매니저");
//			System.out.println("3. 점주");
			System.out.println("2. 프로그램 종료");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				login();
			}else if(selNum==2) {
				break;
			}
			
				
			
		}
	}

	private void login() {
		
	}
}

