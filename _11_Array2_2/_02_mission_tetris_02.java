package _11_Array2_2;

public class _02_mission_tetris_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//테트리스 1
				//tempArr						nowblock
				//	1	1	0					0	0	1
				//	0	1	0	왼쪽 회전>>		1	1	1
				//	0	1	1					1	0	0
		
		int [][]tempArr= { {1,1,0},
							{0,1,0},
							{0,1,1}
							};
		int [][]nowblock= new int [3][3];
		for(int i=0;i<tempArr.length;i++) {
			for(int j=0;j<tempArr[0].length;j++) {
				nowblock[i][j]=tempArr[2-j][i];
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
 * 1번과 마찬가지로 2차원 배열로 생각해서
 * i를 배열의 행, j를 배열의 열로 생각
 * 반시계 방향으로 회전하였을 때의 각 좌표의 변화를 분석
 * 2중for문을 사용해 배열을 순회
 * nowblock[i][j]=tempArr[2-j][i]라는 관계를 찾아냄
 */