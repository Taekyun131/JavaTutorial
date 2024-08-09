package _03for;

public class _09_mission_09 {
	public static void main(String[] args) {
		//9.i를 피보나치 수로 정의 
		int j=0;
		for(int i=1;i<20;) {
			System.out.print(i+"/");
			i+=j;
			j=i-j;
		}
	}
}
