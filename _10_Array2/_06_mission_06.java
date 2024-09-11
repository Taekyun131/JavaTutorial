package _10_Array2;

public class _06_mission_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//6. 2차원 배열의 모든 값을 출력하시오
		//	출력할 때는 행의 번호는 내림차순, 열의 번호도 내림차순으로 출력하시오
		int[][] a= { {1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.println(a[a.length-1-i][a[0].length-1-j]);
			}
		}
	}

}


/* 분석
 * 2차원배열의 값을 출력해야하므로 
 * i값을 행, j값을 열로 생각해 2중for문을 작성
 * i는 0부터 4까지 1씩증가, j는 0부터 4까지 1씩증가
 * 내림차순으로 출력해야하므로 출력하는 값을 보정
 */