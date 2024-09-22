package _03for;

public class _07_mission_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//7.System.out.print() 명령어를 사용해 "1+2+3+4+5+6+7+8+9+10=결과값"이 출력되는 코드작성
		//System.out.print()=줄바꿈하지 않고 출력하는 명령어
		String sign="+";
		int sum7=0;
		for(int i=1;i<=10;i++) {
			sum7+=i;
			if(i==10) {
				sign="=";
			}
			System.out.print(i+sign);
		}
		System.out.print(sum7);
	}

}
