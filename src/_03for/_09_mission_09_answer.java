package _03for;

public class _09_mission_09_answer {

	public static void main(String[] args) {
		
		//피보나치 수열
		
		int bint=0;
		for(int i=1;i<20;) {
			System.out.println(i);
			int temp=i;//이전 i를 저장할 변수생성
			i=bint+i;
			bint=temp;
					
		}
		
		
		
		
		
		
	}
}
