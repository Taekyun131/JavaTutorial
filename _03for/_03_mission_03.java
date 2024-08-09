package _03for;

public class _03_mission_03 {
	public static void main(String[] args) {
		//3.1부터 100까지 숫자중 홀수의 개수
		int countOdd=0;
		for(int i=0;i<=100;i++) {
			if(i%2!=0) {
				countOdd++;
			}
		}
		System.out.println("홀수의 개수: "+countOdd);
	}
}
