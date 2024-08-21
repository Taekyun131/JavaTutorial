package _06_Random;

import java.util.Scanner;

public class _01_mission_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//키보드로 두 개의 숫자를 입력받아서 합하는 프로그램을 작성하세요.
		int sum=0;
		Scanner In=new Scanner(System.in);
		int k1=In.nextInt();
		int k2=In.nextInt();
		In.nextLine();
		sum=k1+k2;
		System.out.println(sum);
		In.close();
	}

}
