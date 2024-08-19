package _07_2for;

public class _11_mission_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		000*
//		00***
//		0*****
//		*******
//		0*****
//		00***
//		000*
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<3-i;j++) {
				System.out.print(0);
			}
			for(int k=0;k<2*i+1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print(0);
			}
			for(int k=0;k<5-2*i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
