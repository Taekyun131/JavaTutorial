package _10_Array2;

import java.util.Scanner;

public class _09_mission_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*10. 키보드로 좌표를 입력하면, 좌표기준으로 왼쪽 또는 오른쪽으로
		 * 3개 이상의 연속된 숫자가 있으면 제거가능
		 * 제거가능이면 제거를 하고, 위에 있는 숫자가 아래로 내려온다
		 * 맨위에 배열은 랜덤수로 채워진다.
		 */
		int [][]game= {{1,1,0,2},
						{3,2,1,2},
						{0,0,3,2},
						{4,4,4,4},
						{2,4,3,1},
						{2,4,1,3}
			};
		for(int i=0;i<game.length;i++){
			for(int j=0;j<game[0].length;j++) {
				System.out.print(game[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====제거할 좌표를 입력하세요(행: 첫번째 숫자, 열: 두번째 숫자)=====");
		Scanner in=new Scanner(System.in);
		int x=in.nextInt();
		int y=in.nextInt();
//		System.out.println(x+","+y);
		
	
			
		
	}

}
