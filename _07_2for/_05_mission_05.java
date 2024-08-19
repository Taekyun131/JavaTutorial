package _07_2for;

public class _05_mission_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//40보다 큰 수는 모두 몇개인가?
		int count=0;
		int[] a ={34,55,23,56,34,45,34};
		for(int i=0;i<a.length;i++) {
			if(a[i]>40) {
				count++;
			}
		}
		System.out.println(count);
	}
}
