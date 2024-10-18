package ob2_login;

import java.util.Scanner;

import ob2_staff.Staff;
import ob2_staff_dao.StaffDAO;

public class LoginStaff {
	Staff s=null;
	StaffDAO sdao=StaffDAO.getInstance();
	public void menu(Staff s) {
		this.s=s;
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 오늘 근무시간 입력");
			System.out.println("2. 총 근무시간 조회");
			System.out.println("3. 정보조회");
			System.out.println("4. 정보수정");
			System.out.println("5. 로그아웃");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				System.out.println("근무시간을 입력하세요");
				int wtime=in.nextInt();
				in.nextLine();
				sdao.addWtime(s, wtime);
				s.setWorkTime(wtime);
			}else if(selNum==2) {
				System.out.println("총 근무시간:"+s.getWorkTime());
			}else if(selNum==3) {
				System.out.println(s.toString());
			}else if(selNum==4) {
				String id=s.getId();
				System.out.println("변경할 비밀번호를 입력하세요");
				String pwd=in.nextLine();
				System.out.println("변경할 이름을 입력하세요");
				String name=in.nextLine();
				sdao.modInfo(id, pwd, name);
			}else if(selNum==5) {
				break;
			}
		}
	}
}
