package _11_Array2_2;

public class _09_mission_06_m {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//6.	1	2	3	4	5		6	1	2	3	4
		//		6	7	8	9	10		11	12	7	8	5
		//		11	12	13	14	15	>>	16	17	13	9	10
		//		16	17	18	19	20		21	18	19	14	15
		//		21	22	23	24	25		22	23	24	25	20
		// 새로운 배열 선언x
		int [][]a= {{1,2,3,4,5},
					{6,7,8,9,10},
					{11,12,13,14,15},
					{16,17,18,19,20},
					{21,22,23,24,25}
					};
		
		//풀이
		//바깥쪽 시계방향회전
//		for(int j=0;j<a[0].length-2;j++) {
//			a[0][a[0].length-j-1]=a[0][a[0].length-j-2];
//		}
//		for(int i=0;i<a.length-2;i++) {
//			a[a.length-1-i][4]=a[a.length-2-i][4];
//		}
//		for(int j=0;j<a[0].length-2;j++) {
//			a[4][j]=a[4][j+1];
//		}
//		for(int i=0;i<a.length-2;i++) {
//			a[i][0]=a[i+1][0];
//		}
		
		for(int j=0;j<a[0].length-1;j++) {
			a[0][j+1]--;
		}
		for(int i=0;i<a.length-1;i++) {
			a[i+1][4]-=5;
		}
		for(int j=0;j<a[0].length-1;j++) {
			a[4][j]++;
		}
		for(int i=0;i<a.length-1;i++) {
			a[i][0]+=5;
		}
		
		
		
		
		
		//출력
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+"\t ");
			}
			System.out.println();
		}
		
	}
 
}
