package _02if;

public class _01_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*수강관리 프로젝트를 진행한다.
		학생의 정보는 이름 학번 나이 성적이다.
		나이가 18세 미만은 수강신청을 할 수 없다.
		성적이 60점 이상이면서 70점 미만인 학생은 수강신청을 할 수 있지만, 이름 뒤에 별표를 추가한다.
		학생의 성적을 기준으로 
		90점 이상 A
		80점 이상 B
		70점 이상 C
		60점 이상 D
		60점 미만 F 출력*/
		
		String name="신태균";
		int num;
		int age=18;
		int score=66;
		String grade;
		if(age<18) {
			System.out.println("18세 미만은 수강신청 불가");
		}else {
			if(score>=90) {
				grade="A";
			}else if(score>=80) {
				grade="B";
			}else if(score>=70) {
				grade="C";
			}else if(score>=60) {
				name+="*";
				grade="D";
			}else {
				grade="F";
			}
			
			System.out.println(name+"/"+grade);
		}
	}

}
