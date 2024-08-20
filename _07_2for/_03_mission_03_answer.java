package _07_2for;

public class _03_mission_03_answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	000*
	//		00***
	//		0*****
	//		*******
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4+i;j++) {
				if(j>=3-i) {
					System.out.print("*");
				}else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}
}