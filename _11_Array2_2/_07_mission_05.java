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


/* 분석
 * 2차원배열의 숫자는 (0,0)에서 시작해 소용돌이 모양으로 회전
 * 1개의 행 또는 열을 for문을 사용해 숫자의 진행방향으로 하나씩 출력해봄
 * 가로로 진행하는 숫자는 개수가 5(1~5), 4(9~12), 3(15~17), 2(19~20)으로 1씩 감소
 * 세로로 진행하는 숫자는 개수가 3(6~8), 2(13~14), 1(18) 로 1씩 감소
 * 가로로 진행하는 숫자는 오른쪽으로 진행할 때와 왼쪽으로 진행할 때의 코드구조가 각각 일치
 * 세로로 진행하는 숫자는 위쪽으로 진행과 아래방향 코드 구조 각각 일치
 * 숫자의 진행방향이 같은 
 */