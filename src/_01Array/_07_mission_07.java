package _01Array;

public class _07_mission_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money=2750;
		int pay=10000;
		int change=pay-money;
		int changeMoney[]=new int[4];
		changeMoney[0]=change;
		changeMoney[1]=((change/1000)%10);
		changeMoney[2]=((change/100)%10);
		changeMoney[3]=((change/10)%10);
		System.out.println("잔돈: "+changeMoney[0]+" 천원: "+changeMoney[1]+
				" 백원: "+changeMoney[2]+" 십원: "+changeMoney[3]);
	}

}
