package _05for_03;

import java.util.Random;

public class _09_mission_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Random이라는 클래스로 객체를 만들어서 r이라는 참조변수로 참조해서 사용해 보자~
		Random r = new Random();  
		int num = r.nextInt(45)+1;
		로또번호를 자동으로 생성하는 게임을 작성하시오.
		중복허용 가능, 로또 번호 6개를 배열에 저장하고, 출력하시오.*/
//		import java.util.Random;
		Random r=new Random();
		int []lotto=new int[6];
		for(int i=0;i<lotto.length;i++) {
			lotto[i]=r.nextInt(45)+1;
		}
		System.out.println(lotto[0]+"/"+lotto[1]+"/"+lotto[2]
				+"/"+lotto[3]+"/"+lotto[4]+"/"+lotto[5]);
		
	}

}
