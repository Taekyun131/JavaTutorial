package _04for_02;

public class answer_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ttt="aabbbcccaaaaddbbbaaaaa";
		int cnt=0;
		char bT=ttt.charAt(0);
		int maxCnt=0;
		int maxNumber=0;
		for(int i=0;i<ttt.length();i++) {
			if(bT==ttt.charAt(i)){
				cnt++;
			}else {
				bT=ttt.charAt(i);
				cnt=1;
			}
			if(maxCnt<cnt) {
				maxCnt=cnt;
				maxNumber=bT;
			}
		}
		System.out.println(maxCnt+"/"+(char)maxNumber);
	}

}
