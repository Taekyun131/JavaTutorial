package 수강신청_answer;

import java.util.ArrayList;
import java.util.Scanner;

public class Stu {
	private String id=null;
	private String name=null;
	private String tel=null;
	private int grade=0;
	private PartMge partMge=null;
	private ArrayList<Part> myList=new ArrayList<>();
	
	public void menu(PartMge pmge) {
		partMge=pmge;
		while(true) {
			 Scanner in=new Scanner(System.in);
			 System.out.println("1. 수강신청");
			 System.out.println("2. 신청목록");
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
	private void add() {
		Scanner in=new Scanner(System.in);
		//교과목의 리스트를 보여줘야 하는데, 이 리스트는PartMge
		ArrayList<Part> getList=partMge.getPlist();
		for(int i=0;i<getList.size();i++) {
			System.out.println("과목번호: "+i);
			getList.get(i).prt();
		}
		System.out.println("번호선택");
		int choiceNum=in.nextInt();
		in.nextLine();
		myList.add(getList.get(choiceNum));
		
		
	}
	private void list() {
		for(int i=0;i<myList.size();i++) {
			System.out.println("수강신청 목록");
			myList.get(i).prt();
		}
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public ArrayList<Part> getMyList() {
		return myList;
	}

	public void setMyList(ArrayList<Part> myList) {
		this.myList = myList;
	}
	public void prt() {
		System.out.println("아이디: "+id);
		System.out.println("이름:  "+name);
	}
}

