package _01Array;

public class _05_missioin_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []lotto= {6,12,33,4,5,26};
		lotto[0]=6;
		lotto[1]+=lotto[0];
		lotto[2]+=lotto[1];
		lotto[3]+=lotto[2];
		lotto[4]+=lotto[3];
		lotto[5]+=lotto[4];
		System.out.println(lotto[0]+"/"+lotto[1]+"/"+lotto[2]+"/"+lotto[3]
				+"/"+lotto[4]+"/"+lotto[5]);
	}

}
