package _03for_02;

public class _13_mission02_13 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//숫자가 터널일 때, 터널의 길이가 가장 긴 숫자와 길이 출력
		int a=0;
		int b=0;
		int count=1;
		int maxCount=0;
		int[] arr= {1,2,3,0,0,0,1,2,2,4,2,2,2,2,2,2,0,0,0,0,0,3,3};
		for(int i=0;i<22;i++) {
			if(arr[i]==a) {
				count++;
			}else {
				count=1;
			}
			if(count>maxCount) {
				maxCount=count;
				b=arr[i];
			}
			a=arr[i];
		}
		System.out.println(maxCount+"/"+b);
		
	}

}
