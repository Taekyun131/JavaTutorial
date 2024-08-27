package _07_2for;

public class _06_mission_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* b배열의 값보다 큰 값이 a 배열의 값에 모두 몇개가 있는가?
			각각 카운팅 하시오 
			출력은
			 a 배열의 값에는  36번호 보다 큰 숫자가 ?? 개 있습니다.
			 a 배열의 값에는  49번호 보다 큰 숫자가 ?? 개 있습니다.*/
		
		int count=0;
		int[] a ={34,55,23,56,34,45,34};
		int[] b ={36,49};
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(b[i]<a[j]) {
					count++;
				}
			}
			System.out.println("a 배열의 값에는 "+b[i]+"보다 큰 숫자가 "+count+"개 있습니다.");
			count=0;
		}
	}

}
