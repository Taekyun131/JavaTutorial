package _07_2for;

public class _01_mission_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 1*1=1  1*2=2   1*3=3
		2*1=2  2*2=4   2*3=6
		3*1=3  3*2=6   3*3=9
		4*1=4  4*2=8   4*3=12 */
		
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=3;j++) {
				System.out.print(i+"*"+j+"="+(i*j)+" ");
			}
			System.out.println();
		}
	}

}
