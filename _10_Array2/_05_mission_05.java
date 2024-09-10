package _10_Array2;

public class _05_mission_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5.전체배열의 값 중 홀수를 0으로 마스킹하고, 마스킹된 결과를 2차원 배열로 출력
		int[][] a= { {1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(a[i][j]%2!=0) {
					a[i][j]=0;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
