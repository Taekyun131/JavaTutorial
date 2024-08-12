package _04for_02;

public class answer_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr={1,2,3,0,0,0,1,2,3,4,5,2,2,2,2,0,0,0,0,0,0,0};
		int cnt=1;
		int bT=arr[0];
		int maxLength=0;
		int maxIndex=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==bT) {
				cnt++;
			}else {
				cnt=1;
				bT=arr[i];
			}
//			System.out.println(i+"/"+cnt);
			if(maxLength<cnt) {
				maxLength=cnt;
				maxIndex=bT;
			}
		}
		
		System.out.println(maxLength);
		System.out.println(maxIndex);
	}
}
