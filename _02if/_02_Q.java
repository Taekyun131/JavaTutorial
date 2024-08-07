package _02if;

public class _02_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int a=10;
		int b=20;
		int my=15;
		문제 a와 b는 도로의 길이이며 위치이다.
		my는 나의 위치이다.
		내가 도로위에 있으면 도로위, 도로위가 아니라면 도로가 아님이라고 출력하시오
		up1
		만약 내가 도로위라면 
		a 지점으로부터 5(my 위치에 따라 달라짐)만큼 떨어져 있습니다 라고 출력하시오
		
		up2
		up1에서 현재 my의 위치가 가까운 쪽 기준으로 출력한다.
		예를 들어 my 18이면 b에 더 가까우니 b에서부터 2거리 떨어져 있습니다.*/
		
		int a=10;
		int b=20;
		int my=16;
		
		if((my<=b)&&(my>=a)) {
			System.out.println("도로 위");
			if((b-my)>=(my-a)) {
				System.out.println("a지점으로부터 "+(my-a)+" 만큼 떨어져있습니다." );
			}else {
				System.out.println("b지점으로부터 "+(b-my)+" 만큼 떨어져있습니다.");
			}
		}else {
			System.out.println("도로가 아님");
		}
			
	}

}
