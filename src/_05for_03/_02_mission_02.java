package _05for_03;

public class _02_mission_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//범인찾기: 짝수이면서 가장 큰 값
		int []letter={8,12,4,13,2,14,4,5};
		int even=0;
		int maxVal=0;
		for(int i=0;i<letter.length;i++) {
			if(letter[i]%2==0) {
				even=letter[i];
			}
			if(even>maxVal) {
				maxVal=even;
			}
		}
		System.out.println(maxVal);
	}

}
