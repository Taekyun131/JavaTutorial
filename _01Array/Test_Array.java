package _01Array;

public class Test_Array {

	public static void main(String[] args) {
		//문제1
		int [] numArray= {30,40,50,60,55};
		
		System.out.println(numArray[0]+"/"+numArray[1]+"/"+numArray[2]+"/"
				+numArray[3]+"/"+numArray[4]);
		
		//문제2
		String [] nameArray= {"kim","lee","park"};
		
		System.out.println(nameArray[0]+"/"+nameArray[1]+"/"+nameArray[2]);
		
		//문제3
		int []lotto= {6,12,33,4,5,26};
		System.out.println(lotto[2]+2);
		
		//문제4
		System.out.println(lotto[0]+lotto[2]+lotto[4]);
		
		//문제5
		lotto[0]=6;
		lotto[1]+=lotto[0];
		lotto[2]+=lotto[1];
		lotto[3]+=lotto[2];
		lotto[4]+=lotto[3];
		lotto[5]+=lotto[4];
		System.out.println(lotto[0]+"/"+lotto[1]+"/"+lotto[2]+"/"+lotto[3]
				+"/"+lotto[4]+"/"+lotto[5]);
		
		//문제6
		int []lotto2= {6,12,33,4,5,26};
		System.out.println((lotto2[3]%2)!=0);
		
		//문제7
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
		
		//문제8
		int xA=700;
		int yA=500;
		int xB=900;
		int yB=300;
		int xC=650;
		int yC=150;
		
		int bunker[]= {xA,yA,xB,yB};
		
		int ball[]= {xC,yC,xC+3,yC-3};
		
		System.out.println((ball[0]>bunker[0])&&(ball[1]<bunker[1])&&
				(ball[2]<bunker[2])&&(ball[3]>bunker[3]));
		
	}

}
