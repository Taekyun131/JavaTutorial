package _07_2for;

public class _09_mission_09_answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가장 긴 터널의 알파벳 이름과 숫자를 찾으세요 <이중For사용>
		//알고리즘에 사용되는 코드
		String ttt ="aabbbcccaaaaddbbbaaaaa";
		int cnt=0;
		int maxCnt=0;
		for(int i=0;i<ttt.length();i++) {
			char temp=ttt.charAt(i);
			cnt=0;
			if(temp=='a') { //가장 긴 a 찾기
				//i값 위치를 시작으로 연속된 a의 길이
				for(int j=i;j<ttt.length();j++) {
					if(ttt.charAt(j)!='a') {
						break;
					}else {
						cnt++;
					}
				} 
				if(maxCnt<cnt) {
					maxCnt=cnt;
				}
				i=i+cnt-1;//i값 보정을 통해 중복검색차단
				System.out.println(maxCnt);
			}
		}
	}
}


