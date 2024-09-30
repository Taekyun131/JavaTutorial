package _18_접근제어자_01;

import _18_접근제어자_02.MemberOne;

public class Main {

	public static void main(String[] args) {
		MemberOne m=new MemberOne();
//		m.name="hong";//err>name변수 접근제어자 default
		m.prt(); //가능
		m.setName("1234");
		m.setName("4567");
	}

}
