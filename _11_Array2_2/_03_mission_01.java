package _11_Array2_2;

public class _03_mission_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.	17	13	9	5	1
		//		18	14	10	6	2
		//		19	15	11	7	3
		//		20	16	12	8	4
		
		//배열값 입력부
		int[][]a=new int[4][5];
		int num=1;
		
		//풀이
		for(int j=0;j<a[0].length;j++) {
			for(int i=0;i<a.length;i++) {
				a[i][a[0].length-j-1]=num;
				num++;
			}
		}
		
		//출력
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}


/* 분석
 * 2차원 배열을 보면 숫자의 순서가 
 * 행은 위에서부터 차례로 증가하고
 * 열은 오른쪽에서부터 차례로 증간한다.
 * 2차원 배열의 행을 i, 열을 j로 본다면
 * i는 0부터 3까지 차례로 증가하고, j는 4부터 0까지 감소하여 출력
 * 열이 정해졌을 때 행이 증가하므로 2중for문을 사용하여 j값>>i값 순으로 순회
 * num은 출력될때마다 1씩 증가하므로 num++
 * 
 * 
 */