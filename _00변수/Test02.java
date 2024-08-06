package _00변수;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//오후 문제 풀이
		//주요기능: 변수, 자료형, 연산자
		
		System.out.println("메모장프로그램");
		String title="나의점심";
		String body="오늘은 자장면";
		System.out.println(title +body);
		title="점심 메뉴";
		System.out.println(title);
		int cnt=0;
		body="짬뽕도 먹음";
		cnt=10;
		System.out.println("--------------");
		System.out.println("제목 : "+title);
		System.out.println("본문 : "+body);
		System.out.println("조회수 : "+cnt);
		System.out.println("--------------");
		//body = body+"탕수육도 먹음";
		body += "탕수육도 먹음";
		
		//문제1
		int point=80;
		System.out.println(point);
		
		//문제2
		int firstNumber=10;
		int secondNumber=4;
		System.out.println((1.0*firstNumber)/secondNumber);
		
		//문제3
		String saveName=null;
		saveName="홍길동";
		System.out.println(saveName+"님");
		
		//문제4
		int saveEng=90;
		int saveMath=87;
		int saveCom=100;
		double divInt=3.0;
		double avg;
		avg = (saveEng+saveMath+saveCom)/divInt;
		System.out.println(avg);
		
		//문제5
		boolean flag =false;
		int a = 10;
		flag = (a%3)==0;
		System.out.println(flag);
		System.out.println((a%3)==0);  // 한 줄 정답
	}

}
