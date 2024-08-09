package _03for;

public class _16_mission2_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열에서 값이 홀수인 곳의 인덱스 출력
		int [] arr= {45,23,25,64,3,24,48};
		for(int i=0;i<7;i++) {
			if(arr[i]%2!=0) {
				System.out.println(i);
			}
		}
	}

}
