package _03for;

public class _08_mission_08 {
	public static void main(String[] args) {
		//8.피보나치 수열의 7번째 항까지의 합을 구해 출력, i는 피보나치수열의 개수
		int fib=1;
		int fib2=0;
		int fibSum=0;
		for(int i=1;i<8;i++) {
			fibSum+=fib;
			fib+=fib2;
			fib2=fib-fib2;
		}
		System.out.println("피보나치 수열의 합: "+fibSum);
	}
}
