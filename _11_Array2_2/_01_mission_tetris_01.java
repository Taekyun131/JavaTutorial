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


