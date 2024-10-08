package openIdea;

import java.util.ArrayList;
import java.util.Scanner;


public class Service {
	private IdeaDTO idto=null;
	IdeaDAO idao=new IdeaDAO();
	public Service(){
		
	}
	public void menu() {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 아이디어 제안하기");
			System.out.println("2. 아이디어 수정하기");
			System.out.println("3. 아이디어 삭제하기");
			System.out.println("4. 아이디어 전체보기");
			System.out.println("5. 아이디어 검색하기");
			System.out.println("6. 프로그램 종료");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				add();
			}else if(selNum==2) {
				update();
			}else if(selNum==3) {
				delete();
			}else if(selNum==4) {
				all();
			}else if(selNum==5) {
				search();
			}else if(selNum==6) {
				break;
			}
		}
	}
	//검색
	private void search() {
		ArrayList<IdeaDTO>ilist=idao.all();
		Scanner in=new Scanner(System.in);
		System.out.println("검색할 내용을 입력하세요");
		String s=in.nextLine();
		int count=0;
		for(int i=0;i<ilist.size();i++) {
			IdeaDTO temp=ilist.get(i);
			if(temp.getContent().contains(s)||
					temp.getTitle().contains(s)||
					temp.getWriter().contains(s)) {
				System.out.println(temp.toString());
				count++;
			}
		}
		System.out.println("검색결과: "+ count+"건 있습니다.");
	}
	//전체보기
	private void all() {
		ArrayList<IdeaDTO>ilist=idao.all();
		for(IdeaDTO temp:ilist) {
			System.out.println(temp.toString());
		}
	}
	//삭제
	private void delete() {
		Scanner in=new Scanner(System.in);
		ArrayList<IdeaDTO>ilist=idao.all();
		for(int i=0;i<ilist.size();i++) {
			System.out.println(i+"번: "+ilist.get(i).toString());
		}
		System.out.println("삭제할 번호를 입력하세요");
		int selNum=in.nextInt();
		in.nextLine();
		idao.delete(ilist.get(selNum).getWriter());
	}
	//수정
	private void update() {
		Scanner in=new Scanner(System.in);
		ArrayList<IdeaDTO>ilist=idao.all();
		for(int i=0;i<ilist.size();i++) {
			System.out.println(i+"번: "+ilist.get(i).toString());
		}
		System.out.println("수정할 번호를 입력하세요");
		int selNum=in.nextInt();
		in.nextLine();
		System.out.println("수정할 제목을 입력하세요");
		String ititle=in.nextLine();
		System.out.println("수정할 내용을 입력하세요");
		String icontent=in.nextLine();
		ilist.get(selNum).setTitle(ititle);
		ilist.get(selNum).setContent(icontent);
		idao.update(ilist.get(selNum));
	}
	//제안
	private void add() {
		idto=new IdeaDTO();
		Scanner in=new Scanner(System.in);
		System.out.println("제목을 입력하세요");
		String ititle=in.nextLine();
		System.out.println("내용을 입력하세요");
		String icontent=in.nextLine();
		System.out.println("작성자를 입력하세요");
		String iwriter=in.nextLine();
		idto.setTitle(ititle);
		idto.setContent(icontent);
		idto.setWriter(iwriter);
		idao.add(idto);
		
	}
}

