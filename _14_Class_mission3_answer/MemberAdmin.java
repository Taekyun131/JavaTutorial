package _14_Class_mission3_answer;

import java.util.Scanner;

public class MemberAdmin {
	//고객관리 클래스
		// 의존관계 설정,  중요한 것은 MemberOne객체를 만든 것이 아니다
		// MemberOne 객체의 주소값을 저장할 배열(길이 5)를 생성한 것이다.
		// 배열도 객체입니다.. mlist는 참조변수이고 MemberOne객체의 주소를
		// 저장한 배열의 주소를 저장하고 있다. 
		MemberOne[] mlist = new MemberOne[5];
		
		MemberAdmin() {
			//menu();
		}
		public void menu() {
			Scanner in = new Scanner(System.in);
			while(true) {
				System.out.println("1.고객등록");
				System.out.println("2.전체보기");
				System.out.println("9.이전메뉴");
				int num = in.nextInt();
				in.nextLine();
				if(num==1) {
					addUser();
				}else if(num==2) {
					allListUser();
				}else if(num ==9) {
					break; // while문 종료
				}
			}
		}
		public int duplexIDcheck(String id) {
			for(int i=0; i < mlist.length; i++) {
				if(mlist[i]!=null) {
					if(mlist[i].id.equals(id)) {
						return 1;
						//return을 만나면 함수 종료되고 
						//호출부로 이동 된다. break필요없음
					}
				}
			}
			return 0;
		}
		private void addUser() {
			Scanner in = new Scanner(System.in);
			MemberOne temp = new MemberOne();
			System.out.println("아이디를 입력하세요");
			String id = in.nextLine();
			if(duplexIDcheck(id)==1) {
				System.out.println("입력한 아이디는 중복됨");
			}else {
				temp.id=id;
				System.out.println("이름을 입력하세요");
				String name = in.nextLine();
				temp.name=name;
				
				for(int i=0; i < mlist.length; i++) {
					if(mlist[i]==null) {
						mlist[i]=temp;
						break;
					}
				}
			}		
			temp=null;  // temp에 저장된 주소값이 필요없어서 null처리
			// in.close(); // Scanner 에 필요한 자원 반납
		}
		private void allListUser() {
			// TODO Auto-generated method stub
			for(int i=0; i < mlist.length; i++) {
				if(mlist[i]!=null) {
					mlist[i].prt();
				}
			}
			
		}
}
