package _10_Array2;

public class _03_mission_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3. 2차원 배열의 2열의 모든 값을 행의 순서대로 출력하시오
		int[][] a= { {1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i][2]);
		}
	}

}
