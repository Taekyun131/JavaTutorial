package _03for;

public class _19_mission2_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문자열에 a의 개수 출력
		String test="abcdeabce";
		int count=0;
		for(int i=0;i<9;i++) {
			char aaa=test.charAt(i);
			if(aaa=='a') {
				count++;
			}
		}
		System.out.println(count);
	}

}