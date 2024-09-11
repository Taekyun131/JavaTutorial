package _11_Array2_2;

public class _06_mission_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4.		1	2	4	7	11
		//			3	5	8	12	15
		//			6	9	13	16	18
		//			10	14	17	19	20
		
		//배열값 입력부
		int[][]a=new int[4][5];
		int num=1;
		
		//풀이
		for(int k=0;k<8;k++) {
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a[0].length;j++) {
					if(i+j==k) {
						a[i][j]=num;
						num++;
					}
				}
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
