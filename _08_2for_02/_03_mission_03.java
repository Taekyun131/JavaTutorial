package _08_2for_02;

public class _03_mission_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 1부터 10까지 숫자의 각 팩토리얼의 합을 구하시오.(2중 for로 해결)
		int sum=0;
		int facto=1;
		for(int i=1;i<=10;i++) {
			facto=1;
			for(int j=1;j<=i;j++) {
				facto*=j;
			}
			System.out.println(facto);
			sum+=facto;
		}
		System.out.println(sum);
	}

}
