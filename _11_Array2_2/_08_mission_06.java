package _11_Array2_2;

public class _08_mission_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//6.	1	2	3	4	5		6	1	2	3	4
		//		6	7	8	9	10		11	12	7	8	5
		//		11	12	13	14	15	>>	16	17	13	9	10
		//		16	17	18	19	20		21	18	19	14	15
		//		21	22	23	24	25		22	23	24	25	20
		
		//배열값 입력부
		int [][]a= {{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
				};
		int [][]b=new int [5][5]; 
		//풀이
		
		//바깥쪽 시계방향 회전
//		for(int j=0;j<a[0].length-1;j++) {
//			b[0][j+1]=a[0][j];
//		}
//		for(int i=0;i<a.length-1;i++) {
//			b[i+1][4]=a[i][4];
//		}
//		for(int j=0;j<a[0].length-1;j++) {
//			b[4][a[0].length-j-2]=a[4][a[0].length-j-1];
//		}
//		for(int i=0;i<a.length-1;i++) {
//			b[a.length-i-2][0]=a[a.length-i-1][0];
//		}
		
		//안쪽 시계방향 회전
//		for(int j=0;j<a[0].length-3;j++) {
//			b[1][j+2]=a[1][j+1];
//		}
//		for(int i=0;i<a.length-3;i++) {
//			b[i+2][3]=a[i+1][3];
//		}
//		for(int j=0;j<a[0].length-3;j++) {
//			b[3][a[0].length-j-3]=a[3][a[0].length-j-2];
//		}
//		for(int i=0;i<a[0].length-3;i++) {
//			b[a.length-i-3][1]=a[a.length-i-2][1];
//		}
		//중심
		b[2][2]=13;
	
		//안쪽+바깥쪽 같은 방향끼리 회전
		for(int k=0;k<8;k++) {
			if(k%4==0) {
				for(int j=0;j<a[0].length-k/2-1;j++) {
					b[k/4][j+k/4+1]=a[k/4][j+k/4];
				}
			}else if(k%4==1) {
				for(int i=0;i<a.length-k/2-1;i++) {
					b[i+(k+3)/4][(17-k)/4]=a[i+(k-1)/4][(17-k)/4];
				}
			}else if(k%4==2) {
				for(int j=0;j<a[0].length-k/2;j++) {
					b[(18-k)/4][a[0].length-(k+6)/4-j]=a[(18-k)/4][a[0].length-(k+2)/4-j];
				}
			}else {
				for(int i=0;i<a.length-k/2;i++) {
					b[a.length-(k+5)/4-i][(k-3)/4]=a[a.length-(k+1)/4-i][(k-3)/4];
				}
			}
		}
		
		
		
		
		
		
		//출력
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[0].length;j++) {
				System.out.print(b[i][j]+"\t ");
			}
			System.out.println();
		}
		
	}

}
