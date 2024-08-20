package _08_2for_02;

import java.util.Scanner;

public class _06_mission_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*키보드로 아이디를 입력받는다.
		입력 받은아이디에 특수 문자가 포함 되었는지 확인한다. (유효성)
		특수 문자는 @한개로 정의한다.
		특수문자가 몇 개 포함되었는지 출력합니다.*/
		char a='@';
		String id=" ";
		int count=0;
		Scanner in=new Scanner(System.in);
		id=in.nextLine();
		for(int i=0;i<id.length();i++) {
			if(id.charAt(i)==a) {
				count++;
			}
		}
		System.out.println("ID에 포함된 특수문자: "+count+"개");
	}

}
