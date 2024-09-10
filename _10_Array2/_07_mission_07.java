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
//				System.out.println(i+","+j);
//				System.out.println(count);
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
