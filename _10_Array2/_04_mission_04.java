package _10_Array2;

public class _04_mission_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4. 전체배열의 값 중 짝수는 모두 몇 개 인가
		int[][] a= { {1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		int count=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(a[i][j]%2==0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}


/* 분석
 * 출력할 값이 짝수>>%연산자필요
 * 개수를 세기 위해 값을 저장할 변수 선언, 초기값은 0
 * 2차원배열을 행렬로 봤을 때, i값을 행, j값을 열로보아 
 * 2중for문을 통해 전체 배열을 순회
 * i값은 0부터 4까지 1씩 증가, j값은 0부터 4까지 1씩 증가
 * 짝수를 판별해줄 조건문 필요
 * 짝수는 2로 나누었을 때 나머지가 0이므로 이를 조건식에 사용
 * 짝수일때 변수의 값을 1씩 증가시켜 반복문이 끝난 이후 값을 출력
*/