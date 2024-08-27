package _03for;

public class _05_mission_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5.범인=100부터 999까지의 숫자 중 십의 자리수가 3의 배수인 수, 범인 출력
		for(int i=100;i<1000;i++) {
			int i2=(i/10)%10;
			if(i2%3==0&&i2!=0) {
				System.out.println("범인1: "+i);
			}
		}
	}

}
