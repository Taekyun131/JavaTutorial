package _03for;

public class _00_Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {30,40,50,55,65};
		//65 55 50 40 30 출력
		for(int i=4;i>=0;i--) {
			System.out.println(a[i]);
		}
		
		//40 50 55 65 30 출력
		for (int i=0;i<5;i++) {
			System.out.println(a[((i+1)%5)]);
		}
		
		
		
		
	}

}
