package _03for;

public class _10_mission_10_answer {
	public static void main(String[] args) {
		//10.987654321 변수 2개와 for문 한개로 모든 자리수의 합 출력
		int a=987654321;
		int sum10=0;
		for(;a>0;) {
			sum10+=a%10;
			a=a/10;
			
		}
		System.out.println("sum10: "+sum10);
	}
}
