package _07_2for;

public class _12_mission_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가장 긴 터널의 알파벳 이름과 숫자를 찾으세요. for문 2개만 사용하기 if문은 갯수 상관없음.
		char a=' ';
		char b=' ';
		int count=1;
		int maxCount=0;
		String ttt ="aabbbcccaaaaddbbbaaaaa";
		for(int i=1;i<ttt.length();i++) {
			a=ttt.charAt(i);
		}
		for(int i=0;i<ttt.length()-1;i++) {
			if(ttt.charAt(i)==a) {
				count++;
			}else {
				count=1;
			}
			if(count>maxCount) {
				maxCount=count;
				b=a;
			}
		}
		System.out.println(maxCount+"/"+b);
	}

}
