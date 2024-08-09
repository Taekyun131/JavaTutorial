package _03for;

public class _04_mission_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4.100부터 999까지의 모든 숫자의 합 >> ex)453: 4+5+3=12
		int sum4=0;
		for(int i=100;i<1000;i++) {
			int i1=(i/100)%10;
			int i2=(i/10)%10;
			int i3=i%10;
			sum4+=i1+i2+i3;
		}
		System.out.println("100부터 999까지 숫자의 합: "+sum4);
	}

}
