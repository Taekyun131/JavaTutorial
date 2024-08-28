package _09_mini_Project;

import java.util.Random;
import java.util.Scanner;

public class _05_gugudan_sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------구구단 게임-------");
		int point=0; //점수
		int var1;
		int var2;
		int var3;
		Random r=new Random();
		Scanner in=new Scanner(System.in);
		//1단계
		long start=System.currentTimeMillis();
		long end=start+5*1000;
		while(System.currentTimeMillis()<end) {
			
				for(int i=0;i<10;i++) {
					if(System.currentTimeMillis()>end) {
						break;
					}
					var1=r.nextInt(9)+1;
					var2=r.nextInt(9)+1;
					System.out.println(var1+"x"+var2+"=?");
					int type=in.nextInt();
					int result1=var1*var2;
					if(result1==type) {
						System.out.println("정답!!");
						System.out.println();
						point+=50;
						end=System.currentTimeMillis()+5000;
					}else {
						System.out.println("오답!!");
						System.out.println();
						point-=20;
					}
				}
				System.out.println("1단계 종료");
				System.out.println("현재 점수: "+point);
				System.out.println();
				if(point>=350) {
					System.out.println("1단계 통과!!");
					System.out.println();
				}else {
					System.out.println("1단계 실패!!");
					System.out.println("다시 도전 하시겠습니까?");
//				System.out.println("Enter 키로 다시 도전");
					
				}
			
			System.out.println("Time Out");
		}
		//2단계
		
			for(int i=0;i<10;i++) {
				var1=r.nextInt(9)+1;
				var2=r.nextInt(9)+1;
				var3=r.nextInt(9)+1;
				System.out.println(var1+"x"+var2+"x"+var3+"=?");
				int result2=var1*var2*var3;
				int type=in.nextInt();
				if(result2==type) {
					System.out.println("정답!!");
					System.out.println();
					point+=70;
				}else {
					System.out.println("오답!!");
					System.out.println();
					point-=30;
				}
			}
			System.out.println("2단계 종료");
			System.out.println("현재 점수: "+point);
		
		
		//3단계
		
			for(int i=0;i<10;i++) {
				var1=r.nextInt(9)+1;
				var2=r.nextInt(99)+1;
				
				System.out.println(var1+"x"+var2+"=?");
				int result3=var1*var2;
				int type=in.nextInt();
				if(result3==type) {
					System.out.println("정답!!");
					System.out.println();
					point+=90;
				}else {
					System.out.println("오답!!");
					System.out.println();
					point-=50;
				}
			}
			System.out.println("3단계 종료");
			System.out.println("현재 점수: "+point);
		
	}

}
