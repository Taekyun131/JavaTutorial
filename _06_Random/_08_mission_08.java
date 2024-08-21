package _06_Random;

import java.util.Scanner;

public class _08_mission_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*위 코드에 1-45숫자를 벗어난 숫자를 입력하면
		범위 오류라고 출력하고 다시 번호를 입력할 수 있도록 수정하세요.*/
		
		int[] lotto = new int[6];
		Scanner in = new Scanner(System.in);
		for(;true;) {
			//로또번호 입력받기
			for (int i = 0; i < lotto.length; i++) {
				System.out.println((i + 1) + "번 입력하세요");
				int k = in.nextInt(); 
				in.nextLine();  
				if(k<1||k>45) {
					k=0;
					System.out.println("범위오류!!번호를 다시 입력하세요(1~45)");
					break;
				}else {
					lotto[i] = k;
					continue;
				}
			}
			in.close();
			//로또 번호 출력하기
			if(lotto[5]!=0) {
				for (int i = 0; i < lotto.length; i++) {
					if (i == lotto.length - 1) { 
						System.out.println("보너스 : " + lotto[i]);
					} else {
						System.out.println("로또 번호:"+lotto[i]);
					}
				}
				break;
			}
		}
		
	}

}
