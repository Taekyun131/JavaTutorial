package _10_Array2;

public class _00_sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * 2차원배열
 * 1차원배열에 다시 1차원배열이 있는 것 >> 행과 열로 구성된 배열로 이해
 * 
 */
		//선언
		//2차원 배열 자료형을 저장할 변수 a를 선언
		//2차원 배열은 행이 5, 즉, 0번부터 4번
		//각 행은 열이 4, 즉 0번ㅂ터 3번
		int [][]a =new int [5][4];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		
		int [][] b= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
				{17,18,19,20}};
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[0].length;j++) {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
