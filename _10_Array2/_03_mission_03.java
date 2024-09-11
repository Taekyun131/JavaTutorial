package _10_Array2;

public class _03_mission_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3. 2차원 배열의 2열의 모든 값을 행의 순서대로 출력하시오
		int[][] a= { {1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i][2]);
		}
	}

}


/* 분석
 * 출력할 값의 열은 2로 고정, 행은 0,1,2,3,4로 증가
 * 반복문을 통한 순회 필요
 * i값을 행이라고 생각하면
 * i=0부터 i=4까지 1씩 증가시켜, 2차원배열 a의 2열의 값을 출력
 */
