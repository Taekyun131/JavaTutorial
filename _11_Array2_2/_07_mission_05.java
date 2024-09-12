package _11_Array2_2;

public class _07_mission_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5.		1	2	3	4	5
		//			14	15	16	17	6
		//			13	20	19	18	7
		//			12	11	10	9	8
		
		//배열값 입력부
		int[][]a=new int[4][5];
		int num=1;
		
		//풀이
//		for(int j=0;j<a[0].length;j++) {
//			a[0][j]=num;
//			num++;
//		}
//		for(int i=1;i<a.length;i++) {
//			a[i][4]=num;
//			num++;
//		}
//		for(int j=1;j<a[0].length;j++) {
//			a[3][a[0].length-j-1]=num;
//			num++;
//		}
//		
//		for(int i=1;i<3;i++) {
//			a[a.length-i-1][0]=num;
//			num++;
//		}
//			
//		for (int j=0;j<a[0].length;j++) {
//			a[0][j]=num;
//			num++;
//		}
//		for(int i=0;i<a.length-1;i++) {
//			a[i+1][4]=num;
//			num++;
//		}
			
		//가로
//		for(int k=0;k<4;k++) {
//			if(k%2==0) {
//				for(int j=0;j<a[0].length-k;j++) {
//					a[k/2][j+k/2]=num;
//					num++;
//				}
//			}else {
//				for(int j=0;j<a[0].length-k;j++) {
//					a[(7-k)/2][a[0].length-j-(k+3)/2]=num;
//					num++;
//					}
//				}
//			}
		
		for(int k=0;k<7;k++) {
			if(k%4==0) {
				for(int j=0;j<a[0].length-k/2;j++) {
					a[k/4][j+k/4]=num;
					num++;
				}
			}else if(k%4==1) {
				for(int i=0;i<a.length-(k+1)/2;i++) {
					a[(k+3)/4+i][(17-k)/4]=num;
					num++;
				}
			}else if(k%4==2) {
				for(int j=0;j<a[0].length-k/2;j++) {
					a[(14-k)/4][a[0].length-j-(k+6)/4]=num;
					num++;
				}
			}else {
				for(int i=0;i<a.length-(k+5)/4;i++) {
					a[a.length-i-(k+5)/4][0]=num;
					num++;
				}
			}
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
