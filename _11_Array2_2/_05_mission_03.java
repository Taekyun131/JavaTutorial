package _11_Array2_2;

public class _05_mission_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3. 	1	2	3	4	5
		//		10	9	8	7	6
		//		11	12	13	14	15
		//		20	19	18	17	16
		
		//배열값 입력부
		int[][]a=new int[4][5];
		int num=1;
		
		//풀이
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(i%2==0) {
					a[i][j]=num;
				}else {
					a[i][a[0].length-j-1]=num;
				}
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
 * 2차원 배열의 숫자 순서가 0번째 행과 2번째 행은 0번째열부터 1씩 증가
 * 1번째 행과 3번째 행은 0번째 행부터 1씩 감소]
 * 조건문을 사용해 짝수행과 홀수행을 나눠 코드를 진행
 * 2중for문을 통해 2차원 배열의 행을 i, 열을 j라고 생각하고 순회
 * 짝수와 홀수를 나누기 위한 조건문은 %연산자를 사용해 2로 나눈 나머지를 판별
 * 출력할 때마다 num값은 1씩 증가
 */