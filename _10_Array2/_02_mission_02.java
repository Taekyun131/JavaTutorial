package _10_Array2;

public class _02_mission_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2.2차원 배열 a의 3번째 행에서 짝수의 값만 출력하시오
		int[][] a= { {1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		for(int i=0;i<a[0].length;i++) {
			if(a[3][i]%2==0) {
				System.out.println(a[3][i]);
			}
		}
	}

}
