package _11_Array2_2;

public class _05_mission_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3. 	1	2	3	4	5
		//		10	9	8	7	6
		//		11	12	13	14	15
		//		20	19	18	17	16
		
		//배열값 입력부
		int[][]a=new int[4][5];
		int num=1;
		
		//풀이
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(i%2==0) {
					a[i][j]=num;
				}else {
					a[i][a[0].length-j-1]=num;
				}
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
