package _03for;

public class _06_mission_06 {
	public static void main(String[] args) {
		//6.범인=0부터 100까지 숫자 중 순서대로 합한 값이 44를 넘게하는 숫자, 범인 출력(break 사용금지)
		int sum6=0;
		int you=0;
		for(int i=0;i<=100;i++) {
			sum6+=i;
			if(sum6<=44) {
				you=i;
			}
		}
		System.out.println("범인2: "+(you+1));
	}
}
