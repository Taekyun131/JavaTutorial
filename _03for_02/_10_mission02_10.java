package _03for_02;

public class _10_mission02_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열에서 가장 큰 값과 가장 큰 값이 있는 인덱스 출력
		int [] arr= {45,23,25,64,3,24,48};
		int maxVal=0;
		int maxIndex=0;
		for(int i=0;i<7;i++) {
			if(arr[i]>maxVal) {
				maxVal=arr[i];
				maxIndex=i;
			}
		
		}
		System.out.println(maxVal+"/"+maxIndex);
	}

}
