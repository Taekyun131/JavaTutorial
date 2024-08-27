package _05for_03;

public class _08_mission_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*철수는 배열의 0번 인덱스에 가장 큰 값을 저장하면 될 것이라고 생각한다.
		0번 인덱스가 가장 큰 값이라고 정의하고 1번부터 마지막까지 순회하면서
		가장 큰 값이 나오면 가장 큰 값을 갱신한다.
		위와 같은 방식으로 가장 큰 수를 구하시오.*/
		int[] a = {34,2,35,8,31,45,0};
		for(int i=1;i<a.length-1;i++) {
			if(a[i]>a[0]) {
				a[6]=a[0];
				a[0]=a[i];
				a[i]=a[6];
			}
		}
		for(int i=2;i<a.length-1;i++) {
			if(a[i]>a[1]) {
				a[6]=a[1];
				a[1]=a[i];
				a[i]=a[6];
			}
		}
		for(int i=3;i<a.length-1;i++) {
			if(a[i]>a[2]) {
				a[6]=a[2];
				a[2]=a[i];
				a[i]=a[6];
			}
		}
		for(int i=4;i<a.length-1;i++) {
			if(a[i]>a[3]) {
				a[6]=a[3];
				a[3]=a[i];
				a[i]=a[6];
			}
		}
		for(int i=5;i<a.length-1;i++) {
			if(a[i]>a[4]) {
				a[6]=a[4];
				a[4]=a[i];
				a[i]=a[6];
			}
		}
		System.out.println(a[0]+"/"+a[1]+"/"+a[2]+"/"+a[3]+"/"+a[4]+"/"+a[5]);
		System.out.println(a[0]);
	}
}
