package _00변수;

public class _05_mission_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문제3 int a =10;
		//한 줄을 사용하여  a의 변수가 3의 변수이면 true, 3의 변수가 아니면  false가 출력되게 하시오
		boolean flag =false;
		int a = 10;
		flag = (a%3)==0;
		System.out.println(flag);
		System.out.println((a%3)==0);  // 한 줄 정답
	}

}
