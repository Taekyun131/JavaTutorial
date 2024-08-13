package _05for_03;

public class _14_mission_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*문자열 a는 해충에 대한 숫자를 카운팅한 결과이다.
		해충의 갯수를 모두 합하시오.
		charAt() 메서드만 사용이 가능하다. 
		형변환이 필요하면 검색하여 사용하시오.*/
		 String a ="67/414/1/23/32/45/54/12/11/232";
		 String c="";
		 int sum=0;
		for(int i=0;i<a.length();i++) {
			char b=a.charAt(i);
			if(b>=48&&b<=57) {
				c+=b;
			}else {
				sum+=Integer.parseInt(c);
				c="";
			}
		}
		sum+=Integer.parseInt(c);
		System.out.println(sum);
	}
}
