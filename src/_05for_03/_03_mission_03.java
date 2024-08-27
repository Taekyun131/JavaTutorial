package _05for_03;

public class _03_mission_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*letter  배열은 word문자열 알파벳의 위치이다.
		letter배열의 암호를 풀어서 편지의 내용을 출력하시오.*/
		String word ="gehoudfkimjnlvy";
		int[] letter={8,12,3,13,1,14,3,4};
		for(int i=0;i<letter.length;i++) {
			System.out.print(word.charAt(letter[i]));
		}
	}

}
