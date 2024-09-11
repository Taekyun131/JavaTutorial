package _10_Array2;

import java.util.Random;
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
		Random r=new Random();
		
		
		Scanner in=new Scanner(System.in);
		
		//System.out.println(x+","+y);
		int count=0;
		int insert=0;
		int maxCount=0;
		int temp=0;
		boolean start=true;
		
		int tCount=0;
		int tMaxCount=0;
		int tTemp=game[0][0];
		
		for(;start;) {
			
			for(int i=0;i<game.length;i++){
				System.out.print(i+"행: ");
				for(int j=0;j<game[0].length;j++) {
					System.out.print("\t"+game[i][j]);
				}
				System.out.println();
			}
			System.out.println("\t"+"=====제거할 좌표를 입력하세요(행: 첫번째 숫자, 열: 두번째 숫자)=====");
			int x=in.nextInt();
			int y=in.nextInt();
			if(x>5||y>3) {
				System.out.println("\t"+"다시 입력하세요");
				continue;
			}
			count=0;
			maxCount=0;
			for(int j=0;j<game[0].length;j++) {
				insert=game[x][y];
				if(game[x][j]==insert) {
					count++;
				}else {
					count=1;
				}
				if(maxCount<count) {
					maxCount=count;
					temp=j;
				}
			}
			if(maxCount>=3) {
		//	System.out.println(maxCount+","+temp);
				System.out.println("\t"+"정답");
				for(int k=0;k<maxCount;k++) {
					game[x][temp-(maxCount-k-1)]=-1;
					for(int i=0;i<game.length;i++) {
						for(int j=0;j<game[0].length;j++) {
							if(game[i][j]==-1) {
								if(i==0) {
									game[i][j]=r.nextInt(4);
								}else {
									for(int l=0;l<i;l++) {
										game[i-l][j]=game[i-l-1][j];
									}
									game[0][j]=r.nextInt(4);
								}
							}
						}
					}
				}
				
			}else {
				System.out.println("\t"+"다시 시도하세요");
				
			}
			
		if(maxCount<3) {
			System.out.println("더 이상 제거할 대상이 없습니다.");
			System.out.println("GAMEOVER");
			start=false;
		}
			
//			tMaxCount=0;
//		for(int i=0;i<game.length;i++) {
//			tCount=0;
//			
//			for(int j=0;j<game[0].length;j++) {
//				if(game[i][j]==tTemp) {
//					tCount++;
//				}else {
//					tCount=1;
//				}
//				if(tMaxCount<tCount) {
//					tMaxCount=tCount;
//				}
//			}
//		}
//		if(tMaxCount<3) {
//			for(int i=0;i<game.length;i++){
//				System.out.print(i+"행: ");
//				for(int j=0;j<game[0].length;j++) {
//					System.out.print("\t"+game[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("\t"+"더 이상 제거할 대상이 없습니다");
//			System.out.println("\t"+"숫자교체");
//			for(int i=0;i<game.length;i++) {
//				for(int j=0;j<game[0].length;j++) {
//					game[i][j]=r.nextInt(4);
//					
//				}
//			}
//		}	
//			
		}
	
			
		
	}

}
