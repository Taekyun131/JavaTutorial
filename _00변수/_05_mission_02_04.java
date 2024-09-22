package _00변수;

public class _05_mission_02_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문제2-4 영어점수 90, 수학점수 87, 컴퓨터점수 100 점을 저장하는 변수를 만들고 평균을 구하시오. 
        //점수는 정수만 입력이 되어야 하나 평균은 소숫점까지 나와야 합니다.

		int saveEng=90;
		int saveMath=87;
		int saveCom=100;
		double divInt=3.0;
		double avg;
		avg = (saveEng+saveMath+saveCom)/divInt;
		System.out.println(avg);
	}

}
