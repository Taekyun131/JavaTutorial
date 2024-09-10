package _10_Array2;

public class _08_mission_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//8.위와 같은 게임 배열에서 같은 번호가 가로나 세로로 각각 3개 이상이면 제거가 가능하다.
		//제거가 가능한 블록의 좌표를 출력하시오.
		int [][]game= {{1,1,0,2},
						{3,2,1,2},
						{0,0,3,2},
						{4,4,4,4},
						{2,4,3,1},
						{2,4,1,3}
					};
		
		int count1=0;
		int maxCount1=0;
		int temp1=game[0][0];
		int a1=0;
		int b1=0;
		//세로로 3개이상
		for(int j=0;j<game[0].length;j++) {
			count1=0;
			maxCount1=0;
			for(int i=0;i<game.length;i++) {
				if(game[i][j]==temp1) {
					count1++;
				}else {
					count1=1;
				}
				temp1=game[i][j];
				if(maxCount1<count1) {
					maxCount1=count1;
					a1=i;
					b1=j;	
				}
			}
			if(maxCount1>=3) {
				for(int k=0;k<maxCount1;k++) {
					System.out.println("("+(a1-(maxCount1-k-1))+","+b1+")");
				}
			}
			System.out.println();
		}
			
			
		
		
		//가로로 3개 이상
		int count2=0;
		int maxCount2=0;
		int temp2=game[0][0];
		int a2=0;
		int b2=0;
//		for(int i=0;i<game.length;i++) {
//			if(count2>=3) {
//				for(int k=0;k<count2;k++) {
//					System.out.println("("+a2+","+(b2-(count2-k-1))+")");
//				}
//			}
//			count2=0;
//			for(int j=0;j<game[0].length;j++) {
//				if(game[i][j]==temp2) {
//					count2++;
//				}else {
//					count2=1;
//				}
//				temp2=game[i][j];
//				
//					
////					for(int k=0;k<count2;k++) {
////						System.out.println("("+i+","+(j-(count2-k-1))+")");
////					}
////					System.out.println();
//				
//				a2=i;
//				b2=j;
//			}
//		}
		for(int i=0;i<game.length;i++) {
			count2=0;
			maxCount2=0;
			for(int j=0;j<game[0].length;j++) {
				if(game[i][j]==temp1) {
					count2++;
				}else {
					count2=1;
				}
				temp1=game[i][j];
				if(maxCount2<count2) {
					maxCount2=count2;
					a2=i;
					b2=j;	
				}
			}
			if(maxCount2>=3) {
				for(int k=0;k<maxCount2;k++) {
					System.out.println("("+a2+","+(b2-(maxCount2-k-1))+")");
				}
			}
		}
		
	}
}
