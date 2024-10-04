package 수강신청_answer;

import java.util.ArrayList;
import java.util.Scanner;

public class StuMge {
	 private ArrayList<Stu> slist=new ArrayList<>();
	 
	 public void menu() {
		 while(true) {
			 Scanner in=new Scanner(System.in);
			 System.out.println("1. 등록");
			 System.out.println("2. 검색");
			 System.out.println("3. 전체보기");
			 System.out.println("4. 삭제");
			 int selNum=in.nextInt();
			 if(selNum==1) {
				 add();
			 }else if(selNum==2) {
				 search();
			 }else if(selNum==3) {
				 list();
			 }else if(selNum==4) {
				 delete();
			 }else {
				 break;
			 }
		 }
	 }
	 private void list() {
		 for(int i=0;i<slist.size();i++) {
			 slist.get(i).prt();
		 }
	 }
	 
	 private void add() {
		 Scanner in=new Scanner(System.in);
		 Stu newTemp=new Stu();
		 System.out.println("아이디 입력");
		 String id=in.nextLine();
		 int returnValue=findId(id);
		 if(returnValue==-1) {
			 System.out.println("이름 입력");
			 String name=in.nextLine();
			 newTemp.setId(id);
			 newTemp.setName(name);
			 slist.add(newTemp);
		 }else {
			 System.out.println(id+"는 사용중");
		 }
	 }
	 private void search() {
		 
	 }
//	 private 리턴타입? findId(매개변수?){
	 private int findId(String d) {
		 for(int i=0;i<slist.size();i++) {
			 if(slist.get(i).getId().equals(d)) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 private void delete() {
		 Scanner in=new Scanner(System.in);
		 System.out.println("삭제 아이디 입력");
		 String delId=in.nextLine();
		 int returnValue=findId(delId);
		 if(returnValue!=-1){
			 slist.remove(returnValue);
			 System.out.println("삭제 됨");
		 }
		 //for문은 아이디를 찾는 반복문
		 //아이디를 찾는다는 것은 검색이나 입력에서도 응용가능
		 //그래서 코드의 재사용성을 높이기 위해서 메서드 분리
//		 for(int i=0;i<slist.size();i++) {
//			 if(slist.get(i).getId().equals(delId)) {
//				 slist.remove(i);
//				 break;
//			 }
//		 }
	 }
	 public Stu loginId(String id) {
		 int idx=findId(id);
		 if(idx!=-1) {
			 return slist.get(idx);
		 }
		 return null;
	 }
	 
	 
}
