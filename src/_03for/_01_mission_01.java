package _03for;

public class _01_mission_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.1부터 100까지 숫자 중 홀수는 더하고 짝수는 뺸 결과값 출력
		int sum1=0;
		for(int i=0;i<=100;i++) {
			if(i%2!=0) {
				sum1+=i;
			}else {
				sum1-=i;
			}
		}
		System.out.println("(홀수의 합)-(짝수의 합): "+sum1);
	}

}
