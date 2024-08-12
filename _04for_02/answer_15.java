package _04for_02;

public class answer_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ttt="aabbbcccaaaaddbbbaaaaa";
		String resultZip="";
		int cnt=0;
		char bT=ttt.charAt(0);
		for(int i=0;i<ttt.length();i++) {
			if(bT==ttt.charAt(i)){
				cnt++;
			}else {
				resultZip=resultZip+bT+cnt;
				bT=ttt.charAt(i);
				cnt=1;
			}
			if(i==ttt.length()-1) {
				resultZip=resultZip+bT+cnt;
			}
		}
		System.out.println(resultZip);
	}

}
