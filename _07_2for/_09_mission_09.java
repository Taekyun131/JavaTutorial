package _07_2for;

public class _09_mission_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가장 긴 터널의 알파벳 이름과 숫자를 찾으세요 <이중For사용>
		String ttt ="aabbbcccaaaaddbbbaaaaa";
		int count=1;
		int maxCount=0;
		int maxIndex=0;
		for(int i=0;i<ttt.length();i++) {
			for(int j=i+1;j<ttt.length();j++) {
				if(ttt.charAt(i)==ttt.charAt(j)) {
					count++;
				}else {
					count=1;
					break;
				}
				if(count>maxCount) {
					maxCount=count;
					maxIndex=i;
					count=1;
				}
			}
			System.out.println(maxCount);
			
		}
	}

}
