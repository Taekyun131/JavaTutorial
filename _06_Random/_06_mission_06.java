package _06_Random;

import java.util.Random;

public class _06_mission_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*컴퓨터는 랜덤으로 로또 번호를 10000번 뽑는다.
		가장 많이 뽑힌 로또 번호가 오늘의 추천 로또 번호이다.
		오늘의 추천 로또 번호 하나를 출력하시오.  
		만약 로또 번호가 같은 횟수로 나왔을 경우에는 큰 숫자가 우선한다. */
		int [] count=new int[46];
		int maxLotto=0;
		for(int i=0;i<10000;i++) {
			Random r=new Random();
			int random=r.nextInt(45)+1;
			count[random]++;
		}
		for(int i=0;i<count.length;i++) {
			if(count[i]>=count[0]) {
				count[0]=count[i];
				maxLotto=i;
			}
		}
		System.out.println(maxLotto);
//		for(int i=0;i<count.length;i++) {
//			System.out.println(i+"/"+count[i]);
//		}
	}

}
