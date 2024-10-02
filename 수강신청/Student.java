package 수강신청;

import java.util.ArrayList;

public class Student {
	private String id=null;
	private String name=null;
	private String pn=null;
	private int grade=0;
	private String pwd=null;

	private ArrayList <Class> cList=new ArrayList<>();
	
	
	//getter&setter
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public String getPn() {
		return pn;
	}
	public void setPn(String pn) {
		this.pn = pn;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	//정보출력
	public void prt() {
		System.out.println("아이디: "+id);
		System.out.println("이름: "+name);
		System.out.println("학년: "+grade);
		countClass();
	}
	//수강신청 과목 수
	public void countClass() {
		System.out.println("신청한 과목수: "+cList.size());
	}
	
	//수강신청과목 출력
	public void allClass() {
		System.out.println("신청한 과목");
		for(int i=0;i<cList.size();i++) {
				System.out.println(cList.get(i).getTitle());
		}
	}
	
	//수강신청하기
	 public void regClass(Class c) {
		 cList.add(c);
	 }
}
