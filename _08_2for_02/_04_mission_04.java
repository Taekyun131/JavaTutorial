package _08_2for_02;

public class _04_mission_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*다음조건에 따라 오름차순으로 정렬하시오.
		1. 가장큰 값을 찾아서 맨뒤 값과 교환한다.. 결과  {56,45,83,58,75,93}
		2. 두번째로 큰 값을 찾아서 맨뒤에서 두번째 자리의 값과 교환한다.  결과  {56,45,75,58,83,93}
		3. 세번째로 큰 값을 찾아서 맨뒤에서 세번째 자리의 값과 교환한다.  결과  {56,45,58,75,83,93}
		오름차순으로 정렬이 될때 까지 반복한다.*/
		int a=0;
		int maxVal=0;
		int maxIndex=0;
		int[] b = {93,45,83,58,75,56};
		for(int i=0;i<b.length;i++) {
			maxVal=0;
			maxIndex=0;
			for(int j=0;j<b.length-i;j++) {
				if(b[j]>maxVal) {
					maxVal=b[j];
					maxIndex=j;
				}
			}
			a=b[b.length-i-1];
			b[b.length-i-1]=maxVal;
			b[maxIndex]=a;
		}
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i]);
		}
	}

}
