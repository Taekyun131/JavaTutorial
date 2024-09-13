package _11_Array2_2;

public class _06_mission_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4.		1	2	4	7	11
		//			3	5	8	12	15
		//			6	9	13	16	18
		//			10	14	17	19	20
		
		//배열값 입력부
		int[][]a=new int[4][5];
		int num=1;
		
		//풀이
//		for(int k=0;k<8;k++) {
//			for(int i=0;i<a.length;i++) {
//				for(int j=0;j<a[0].length;j++) {
//					if(i+j==k) {
//						a[i][j]=num;
//						num++;
//					}
//				}
//			}
//		}
		
		//다른 풀이
		for(int i=0;i<8;i++) {
//			System.out.println(i+"번째 채우기를 합니다.");
			int newCol=i;
			for(int j=0;j<=i;j++) {
				if(j>3) continue;
				if(newCol<5) {
//					System.out.println("j<행>"+j+"열"+newCol);
					a[j][newCol]=num++;
				}
				newCol--;
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
 * 2차원 배열의 숫자가 우측상단에서 왼쪽하단으로 대각선 방향으로 진행
 * 2차원 배열의 행을 i, 열을 j라고 한다면
 * 숫자의 위치를 좌표로 살펴보면
 * 1 (0,0)	 							
 * 2 (0,1), 3 (1,0)
 * 4 (2,0), 5 (1,1), 6 (2,0)
 * 각 대각선 별로 i+j의 값이 일정한 상수, 상수는 1씩 증가
 * 2중for문을 사용해 2차원배열을 순회해 i+j의 값이 같은 곳에 숫자를 출력
 * for문을 한 번 더 사용해 i+j의 값인 상수 k를 1씩 증가시킴
 * 
 */