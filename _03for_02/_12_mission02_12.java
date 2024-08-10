package _03for_02;

public class _12_mission02_12 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가장 긴 터널의 길이 구하기(0은 터널)
		int a=0;
		int count=1;
		int maxCount=0;
		int[] arr= {1,2,3,0,0,0,1,2,3,4,5,2,2,2,2,0,0,0,0,0,3,3};
		for(int i=0;i<22;i++) {
			if(arr[i]==a) {
				count++;
			}else {
				count=1;
			}
			if(count>maxCount) {
				maxCount=count;
			}
			a=arr[i];
		}
		System.out.println(maxCount);
	}
}
