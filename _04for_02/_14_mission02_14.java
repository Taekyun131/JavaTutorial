package _04for_02;

public class _14_mission02_14 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가장 긴 터널의 알파벳 이름과 숫자 출력
		String ttt="aabbbcccaaaaddbbbaaaaa";
		char a=' ';
		char b=' ';
		int count=1;
		int maxCount=0;
		for(int i=0;i<22;i++) {
			if(ttt.charAt(i)==a) {
				count++;
			}else {
				count=1;
			}
			if(count>maxCount) {
				maxCount=count;
				b=a;
			}
			a=ttt.charAt(i);
		}
		System.out.println(maxCount+"/"+b);
	}

}
