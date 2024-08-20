package _07_2for;

public class _12_mission_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		000*
//		00***
//		0*****
//		*******
//		0*****
//		00***
//		000*
		//for문 2개만 사용하기 if문은 갯수 상관없음.
		int k=0;
		for(int i=0;i<7;i++) {
			if(i<4) {
				k=4+i;
			}else {
				k=10-i;
			}
			for(int j=0;j<k;j++) {
				if(i<4) {
					if(j>=3-i) {
						System.out.print("*");
					}else {
						System.out.print(0);
					}
				}else {
					if(j>i-4) {
						System.out.print("*");
					}else {
						System.out.print(0);
					}
				}
			}
			System.out.println();
		}
	}
		
}


