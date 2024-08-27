package _04for_02;

public class answer_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test="abcdeabce";
		int cnt=0;
		for(int i=0;i<9;i++) {
			char aaa=test.charAt(i);
//			System.out.println(aaa);
			if(aaa=='a') {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
