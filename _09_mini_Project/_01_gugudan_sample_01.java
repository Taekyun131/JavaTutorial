package _09_mini_Project;

import java.util.Random;
import java.util.Scanner;

public class _01_gugudan_sample_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//구구단 타자게임
		int point=0;
		Random r=new Random();
		int var1=r.nextInt(9)+1;
		int var2=r.nextInt(9)+1;
		int result=var1*var2;
		
		System.out.println(var1+"x"+var2);
		System.out.println("결과: "+result);
		Scanner in=new Scanner(System.in);
		int type=in.nextInt(); 
		if(result==type) {
			System.out.println("정답");
			point+=50;
			System.out.println("점수 +"+point);
		}
	}

}
