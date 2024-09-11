package _11_Array2_2;

public class _03_mission_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.	17	13	9	5	1
		//		18	14	10	6	2
		//		19	15	11	7	3
		//		20	16	12	8	4
		
		//배열값 입력부
		int[][]a=new int[4][5];
		int num=1;
		
		//풀이
		for(int j=0;j<a[0].length;j++) {
			for(int i=0;i<a.length;i++) {
				a[i][a[0].length-j-1]=num;
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
