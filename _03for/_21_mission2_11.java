package _03for;

public class _21_mission2_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//100부터 999까지 숫자중 각 자리수를 더한 값이 짝수인 값 출력
		for(int i=100;i<=999;i++){
			int i1=(i/100)%10;
			int i2=(i/10)%10;
			int i3=i%10;
			int iSum=i1+i2+i3;
			if(iSum%2==0) {
				System.out.println(i);
			}
		}
	}

}
