package _06_Random;

import java.util.Random;
	//Random이라는 클래스를 인식시켜주는 작업
public class _00_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//시나리오..6개의 랜덤한 로또번호 추출
		//로또번호 저장할 배열
		int []lotto=new int[6];
		//랜덤한 번호를 추출하기 위한 객체 만들기
		Random r=new Random();//ctrl+shift+o
		//랜덤한 번호를 뽑기 위한 반복문
		for(int i=0;i<lotto.length;i++) {
//			System.out.println((i+1)+"번째 번호"); 
			int k=r.nextInt(45)+1;
			//r변수를 참조하여 nextInt라는 기능을 호출, 리턴받은 수(0~44)에 +1(보정)을 한다.
			lotto[i]=k;
			}
		//로또번호를 출력하는 반복문
		for(int i=0;i<lotto.length;i++) {
			if(i==lotto.length-1) {//마지막 번호
				System.out.println("보너스: "+lotto[i]);
			}else {
				System.out.println(lotto[i]);
			}
		}
	}

}
