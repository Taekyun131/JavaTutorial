package _04for_02;

public class _02_mission02_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1부터 100까지 숫자중에서 홀수의 총합
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%2!=0) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}

}
