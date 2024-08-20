package _07_2for;

public class _09_mission_09_answer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가장 긴 터널의 알파벳 이름과 숫자를 찾으세요 <이중For사용>
		String ttt ="aabbbcccaaaaddbbbaaaaa";
		int cnt=0;
		int maxCnt=0;
		char maxChar=' ';
		char nowChar=' ';
		for(int i=0;i<ttt.length();i++) {
			nowChar=ttt.charAt(i);
			cnt=0;
			for(int j=i;j<ttt.length();j++) {
				if(ttt.charAt(j)!=nowChar) {
					break;
				}else {
					cnt++;
				}
			if(maxCnt<cnt) {
				maxCnt=cnt;
				maxChar=nowChar;
			}
			i=i+cnt-1;
			}
		}
		System.out.println(maxChar+"/"+maxCnt);
	}
}


