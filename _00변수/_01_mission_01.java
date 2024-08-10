package _00변수;

public class _01_mission_01 {
	public static void main(String[] args) {
		//문제1
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
	}

}
