package _05for_03;

public class _01_mission_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가장 큰 수의 인덱스 출력
		int []letter= {8,12,4,13,2,14,4,5};
		int maxVal=0;
		int maxIndex=0;
		for(int i=0;i<letter.length;i++) {
			if(letter[i]>maxVal) {
				maxVal=letter[i];
				maxIndex=i;
			}
		}
		System.out.println(maxIndex);
	}

}
