package _11_Array2_2;

public class _04_mission_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2.	20	19	18	17	16
		//		15	14	13	12	11
		//		10	9	8	7	6
		//		5	4	3	2	1
				
				//배열값 입력부
				int[][]a=new int[4][5];
				int num=1;
				
				//풀이
				for(int i=0;i<a.length;i++) {
					for(int j=0;j<a[0].length;j++) {
						a[a.length-i-1][a[0].length-j-1]=num;
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
 * 2차원배열을 행렬로 보았을 때
 * 숫자가 행은 3행부터 0까지, 열은  4열부터 0까지 감소한다
 * 2차원 배열의 행을 i, 열을 j라고 생각
 * 2중 for문을 사용하여 행 순회>> 열 순회 순으로 작성
 * num값은 출력할 때마다 1씩 증가하므로 num++
 */