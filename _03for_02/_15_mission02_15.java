package _03for_02;

public class _15_mission02_15 {
	public static void main(String[] args) {
		//문자열 압축하기 압축 하는 방법 a2b3c3a4d2b3a5
		String ttt="aabbbcccaaaaddbbbaaaaa";
		char a='a';
		int count=1;
		String c=" ";
		for(int i=1;i<22;i++) {
			if(ttt.charAt(i)==a) {
				count++;
			}else {
				c+=a;
				c+=count;
				count=1;
			}
			if(i==21) {
				c+=a;
				c+=count;
				
			}
			a=ttt.charAt(i);
			
		}
		System.out.println(c);
	}

}
