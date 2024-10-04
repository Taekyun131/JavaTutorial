package 수강신청_answer;

import java.util.Scanner;

public class MainMenu {
	private StuMge stumanager =null;
	private PartMge partmanager=null;
	private Stu nowUser=null;
	MainMenu(){
		init();
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("메뉴선택");
			menu();
			int selNum=in.nextInt();
			if(selNum==1) {
				goStuMge();
			}else if(selNum==2) {
				goPartMge();
			}else if(selNum==3) {
				loginProcess();
			}
		}
	}
	private void init() {
		if(stumanager==null) {
			stumanager=new StuMge();
		}
		if(partmanager==null) {
			partmanager=new PartMge();
		}
	}
	private void goStuMge() {
		stumanager.menu();
	}
	private void goPartMge() {
		partmanager.menu();
	}
	private void menu() {
		System.out.println("1. 학생관리");
		System.out.println("2. 교과목 관리");
		System.out.println("3. 로그인");
	}
	private void loginProcess() {
		Scanner in=new Scanner(System.in);
		System.out.println("로그인 하세요<id입력>");
		String id=in.nextLine();
		nowUser=stumanager.loginId(id);
		if(nowUser==null) {
			System.out.println("아이디 없음");
		}else {
			System.out.println("로그인 성공/메뉴로 이동");
			nowUser.menu(partmanager);
		}
		
		
	}
	
}
