package _10_Array2;

public class _05_mission_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5.전체배열의 값 중 홀수를 0으로 마스킹하고, 마스킹된 결과를 2차원 배열로 출력
		int[][] a= { {1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(a[i][j]%2!=0) {
					a[i][j]=0;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}

}

/* 분석
 * 전체배열 중 홀수를 찾아내기 위해 2차원배열을 행렬로 생각
 * 이중for문을 통해 i를 행,j를 열로 생각하고 배열을 순회
 * i값은 0부터 4까지 1씩 증가, j값은 0부터 4까지 1씩 증가
 * 홀수를 판별할 조건문 필요
 * 홀수는 2로 나눈 나머지가 1이므로, %연산자를 통해 이를 조건식에 사용
 * 배열을 순회하며 조건식에 참인 값을 0으로 변경
 * 결과를 2차원 배열로 출력해야하므로
 * 다시 2중for문을 작성하여 결과를 출력
 * 
 */
