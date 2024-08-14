package _06_Random;

import java.util.Random;

public class _03_mission_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 1부터 100까지 랜덤 수를 하나 뽑아서 출력한다
		  7의 배수이면 행운의 숫자, 7의 배수가 아니면 행운의 숫자가 나올 때 까지 계속 뽑는다.*/
		Random r=new Random();
		for(;true;) {
			int random=r.nextInt(100)+1;
			if(random%7==0) {
				System.out.println(random+" 행운의 숫자");
				break;
			}else {
				System.out.println(random+" 조심해야한는 숫자");
			}
			
		}
	}

}
