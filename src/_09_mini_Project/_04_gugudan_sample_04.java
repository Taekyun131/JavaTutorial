package _09_mini_Project;

import java.util.Random;
import java.util.Scanner;

public class _04_gugudan_sample_04 {


	public static void main(String[] args) {
		//시간제한
		long start=System.currentTimeMillis();
		long end=start+5*1000;
		
		while(System.currentTimeMillis()<end) {
			
			
			System.out.println("--------구구단 게임-------");
			int point=0; //점수
			int var1;
			int var2;
			Random r=new Random();
			Scanner in=new Scanner(System.in);
			for(int i=0;i<10;i++) {
				if(System.currentTimeMillis()>end) {
					break;
				}
				var1=r.nextInt(9)+1;//변수 1-한자리수
				var2=r.nextInt(9)+1;//변수 2-한자리수 
				System.out.println(var1+"x"+var2+"=?");
				int type=in.nextInt(); //키보드로 정답 입력받기
				int result=var1*var2;  //구구단 정답
				if(result==type) { //정답 시 
					System.out.println("정답!!");
					System.out.println();
					point+=50;
				}else { //오답 시 
					System.out.println("오답!!");
					System.out.println();
					point-=20;
				}
			}
			
			System.out.println("Time Out");
		}
		
		
		
		
	}

}
