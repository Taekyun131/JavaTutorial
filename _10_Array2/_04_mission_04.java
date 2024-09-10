package _10_Array2;

public class _04_mission_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4. 전체배열의 값 중 짝수는 모두 몇 개 인가
		int[][] a= { {1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		int count=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(a[i][j]%2==0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
