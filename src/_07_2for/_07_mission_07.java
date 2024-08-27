package _07_2for;

public class _07_mission_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*거스름돈 구하기   10000원짜리 0개, 1000원짜리 0 개, 100짜리 0개, 10짜리 0개,
		 * 조건 : /나 %연산자는 각각 최대 두 번씩 사용가능
		   단, 거스름돈은 만천원이 최대 값이다. */
		int money=4570;  // 가격
		int pay = 10000;  //지불금액
		int a=0;
		int b=1;
		int change=pay-money;
		for(int i=0;i<4;i++) {
			change=change/10;
			a=change%10;
			b*=10;
			System.out.println(b+"원="+a+"개");
		}
	}

}
