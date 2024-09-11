package _11_Array2_2;

public class _04_mission_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2.	20	19	18	17	16
		//		15	14	13	12	11
		//		10	9	8	7	6
		//		5	4	3	2	1
				
				//배열값 입력부
				int[][]a=new int[4][5];
				int num=1;
				
				//풀이
				for(int i=0;i<a.length;i++) {
					for(int j=0;j<a[0].length;j++) {
						a[a.length-i-1][a[0].length-j-1]=num;
						num++;
					}
				}
				
				//출력
				for(int i=0;i<a.length;i++) {
					for(int j=0;j<a[0].length;j++) {
						System.out.print(a[i][j]+" ");
					}
					System.out.println();
				}
	}

}
