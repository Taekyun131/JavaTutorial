package _08_2for_02;

public class _02_mission_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		배열의 평균값을 구하시오. 소수점 표현하시오.
		int[] arr = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		System.out.println((double)sum/arr.length);
	}

}
