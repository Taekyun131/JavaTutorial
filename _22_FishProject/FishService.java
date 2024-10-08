package _22_FishProject;

import java.util.ArrayList;
import java.util.Scanner;


public class FishService {
	//fishdata 테이블에 데이터를 입력하기 위해서는 fishDAO객체에 의존한다.
	FishDAO fishdao=new FishDAO();
	public void menu() {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("1. 등록");
			System.out.println("2. 삭제");
			System.out.println("3. 검색");
			System.out.println("4. 전체보기");
			System.out.println("5. 수정");
			System.out.println("6. 종료");
			System.out.println("메뉴 선택");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				add();
			}else if(selNum==2) {
				del();
			}else if(selNum==3) {
				search();
			}else if(selNum==4) {
				list();
			}else if(selNum==5) {
				update();
			}else if(selNum==6) {
				break;
			}
		}
		
	}
	private void add() {
		Scanner in=new Scanner(System.in);
		System.out.println("신규 Fish 등록");
		System.out.println("아이디를 입력");
		String id=in.nextLine();
		System.out.println("암호를 입력");
		String pass=in.nextLine();
		//DTO에 저장
		FishDTO fishdto=new FishDTO();
		fishdto.setId(id);
		fishdto.setPwd(pass);
		
		//DAO의 add메서드 호출하여 데이터베이스에 insert
		fishdao.add(fishdto);
	
		
	}
	private void del() {
		Scanner in=new Scanner(System.in);
		System.out.println("삭제할 아이디를 입력하세요");
		String delId=in.nextLine();
		//삭제하기 위한 쿼리문 delete from fishdata where id=?
		//쿼리에 ?가 존재, ?는 위에서 입력받은 값을 저장하는 delId
		fishdao.delete(delId);
	}
	private void search() {
		Scanner in=new Scanner(System.in);
		System.out.println("검색할 아이디를 입력하세요");
		String findId=in.nextLine();
		fishdao.selectOne(findId);
		FishDTO f=fishdao.selectOne(findId);
		if(f!=null) {
			System.out.println(f.toString());
		}
	}
	private void list() {
		ArrayList<FishDTO> f=fishdao.selectAll();
		//DB에 저장된 정보를 모두 출력
		System.out.println(f.size()+"마리의 물고기가 있습니다.");
		for(FishDTO tempf:f) {
			System.out.println(tempf.toString());
		}
	}
	private void update() {
		//시나리오: 먼저 아이디를 입력받아서 해당 정보를 가져온다.
		Scanner in=new Scanner(System.in);
		System.out.println("수정할 아이디를 입력하세요");
		String findId=in.nextLine();
		FishDTO f=fishdao.selectOne(findId);
		if(f!=null) {
			System.out.println("수정할 정보는 다음과 같습니다.");
			System.out.println(f.toString());
		}
		System.out.println("비밀번호를 수정하세요");
		String delPass=in.nextLine();
		f.setPwd(delPass);
		//이제 DTO를 DAO로 넘겨서 uppdate쿼리문을 실행시키면 된다.
		fishdao.update(f);
	}
	
}
