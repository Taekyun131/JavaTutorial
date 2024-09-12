package _11_Array2_2;

public class _01_mission_tetris_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//테트리스 1
		//tempArr						nowblock
		//	1	1	0					0	0	1
		//	0	1	0	오른쪽 회전>>		1	1	1
		//	0	1	1					1	0	0
		
		int [][]tempArr= { {1,1,0},
							{0,1,0},
							{0,1,1}
							};
		int [][]nowblock=new int [3][3];
		for(int i=0;i<tempArr.length;i++) {
			for(int j=0;j<tempArr[0].length;j++) {
				nowblock[i][j]=tempArr[j][2-i];
			}
		}
		
		for(int i=0;i<nowblock.length;i++) {
			for(int j=0;j<nowblock[0].length;j++) {
				System.out.print(nowblock[i][j]);
			}
			System.out.println();
		}
		
	}
}

/* 분석
 * tempArr 모양을 2차원배열로 생각 
 * i를 배열의 행, j를 배열의 열로 생각
 * 2중for문을 사용해 배열을 순회
 * tempArr(0,0)부터 tempArr(2,2)까지 시계방향으로 회전할 때
 * 어떤 좌표로 변하는지 하나씩 분석하여
 * nowblock[i][j]=tempArr[j][2-i]라는 관계를 찾아냄
 * 
 */

