package _09_mini_Project;

import java.util.Random;
import java.util.Scanner;

public class _03_gugudan_sample_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------구구단 게임-------");
		int point=0; //점수
		int var1;
		int var2;
		Random r=new Random();
		Scanner in=new Scanner(System.in);
		for(int i=0;i<10;i++) {
			var1=r.nextInt(9)+1;
			var2=r.nextInt(9)+1;
			System.out.println(var1+"x"+var2+"=?");
			int type=in.nextInt();
			int result=var1*var2;
			if(result==type) {
				System.out.println("정답!!");
				System.out.println();
				point+=50;
			}else {
				System.out.println("오답!!");
				System.out.println();
				point-=20;
			}
		}
		System.out.println("1단계 종료");
		System.out.println("현재 점수: "+point);
		
	}

}
