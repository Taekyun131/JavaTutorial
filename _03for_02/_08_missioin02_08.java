package _03for_02;

public class _08_missioin02_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열에서 짝수의 개수 출력
		int count=0;
		int [] arr= {45,23,25,64,3,24,48};
		for(int i=0;i<7;i++) {
			if(arr[i]%2==0) {
				count++;
			}
		}
		System.out.println(count);
	}

}
