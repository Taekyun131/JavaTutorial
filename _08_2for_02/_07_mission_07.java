package _08_2for_02;

import java.util.Scanner;

public class _07_mission_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*키보드로 아이디를 입력 받는다.
		입력 받은 아이디에 특수문자가 포함되었는지 확인한다. (유효성)
		특수문자는 String sign="!@#$%^&*"로 정의한다.
		특수문자가 몇 개 포함되었는지 출력합니다. */
		
		String sign="!@#$%^&*";
		String id=" ";
		int count=0;
		char temp=' ';
		Scanner in=new Scanner(System.in);
		id=in.nextLine();
		for(int i=0;i<sign.length();i++) {
			temp=sign.charAt(i);
			for(int j=0;j<id.length();j++) {
				if(id.charAt(j)==temp) {
					count++;
				}
			}
		}
		System.out.println("ID에 포함된 특수문자: "+count+" 개");
		
	}

}
