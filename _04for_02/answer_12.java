package _04for_02;

public class answer_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문제12 
		int [] arr={1,2,3,0,0,0,1,2,3,4,5,2,2,2,2,0,0,0,0,0,0,0};
		int cnt=0;
		int maxLength=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				cnt++;
			}else {
				cnt=0;
			}
//			System.out.println(i+"/"+cnt);
			if(cnt>maxLength) {
				maxLength=cnt;
			}
		}
		System.out.println(maxLength);
	}	

}
