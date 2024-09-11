package _10_Array2;

public class _07_mission_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//7.다음과 같은 게임배열에서 같은 번호가 세로로 연속 3개 이상이면 제거가 가능하다.
		//제거가 가능한 블록의 좌표를 출력하시오
		//	1	1	0	2
		//	3	2	1	2
		//	0	0	3	2
		//	4	4	4	4
		//	2	4	3	1
		//	2	4	1	3
		int [][]game= {{1,1,0,2},
						{3,2,1,2},
						{0,0,3,2},
						{4,4,4,4},
						{2,4,3,1},
						{2,4,1,3}
						};
		int count=0;
		int temp=game[0][0];
		
	
		for(int j=0;j<game[0].length;j++) {
			count=0;
			for(int i=0;i<game.length;i++) {
				if(game[i][j]==temp) {
					count++;
				}else {
					count=1;
				}
				temp=game[i][j];
//				System.out.println("a: "+game[i][j]);
//				System.out.println(count);
				if(count>=3) {
//					System.out.println(i+","+j);
//					System.out.println(count);
//				
					for(int k=0;k<count;k++) {
						System.out.println("("+(i-(count-k-1))+","+j+")");
					}
					System.out.println();
				}
			}
		
		
		}
	}

}


/* 분석
 * 세로로 같은 숫자 연속 3개 이상이면 블록의 좌표 출력
 * 2차원배열을 행렬로 생각
 * i값을 2차원배열의 행, j값을 열이라하면
 * j값을 0부터 4까지 변화시킬 때, i값을 0부터 4까지 변화
 * 같은 숫자인 개수를 세어줄 변수 선언하고, 열이 바뀔 때마다 0으로 초기화
 * 배열값과 같은지 비교할 변수 선언하고, 비교 후 변수는 해당 배열값으로 치환
 * 변수와 배열값이 같은지 비교할 조건문 작성
 * 같으면 개수를 세어주는 변수 증가, 다르면 변수를 1로 초기화
 * 개수가 3이상이면 제거가능한 좌표를 출력
 * 개수마다 출력할 값 보정
 * 
 */
