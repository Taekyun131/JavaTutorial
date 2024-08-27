package _06_Random;

import java.util.Random;

public class _05_mission_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*로또번호를 자동으로 생성하는 게임을 작성하시오.
		중복허용 가능, 로또 번호 6개를 배열에 저장하고, 출력하시오.*/
		int []lotto=new int[6];
		for(int i=0;i<lotto.length;i++) {
			Random r=new Random();
			int random=r.nextInt(45)+1;
			lotto[i]=random;
		}
		for(int i=0;i<lotto.length;i++) {
			System.out.println(lotto[i]);
		}
	}

}
