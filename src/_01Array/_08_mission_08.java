package _01Array;

public class _08_mission_08 {
	public static void main(String[] args) {
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
