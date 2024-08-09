package _03for;

public class _02_mission_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2.1부터 100까지 숫자 중 홀수끼리 더한 값, 짝수끼리 더한 값 각각 출력
		int sum2Odd=0;
		int sum2Even=0;
		for(int i=0;i<=100;i++) {
			if(i%2!=0) {
				sum2Odd+=i;
			}else {
				sum2Even+=i;
			}
		}
		System.out.println("홀수들의 합: "+sum2Odd+"/"+"짝수들의 합: "+sum2Even);
	}

}
