package _18_접근제어자_02;

public class CatDTO {
	private String name=null;
	private int age=1;
	//멤버변수는 접근제어자로 은닉화 시킨다
	//은닉화시키면 catDTO클래스 외부에서 변수에 참조?
	//	>>멤버변수 저장 및 인출에 관련된 메서드 사용
	//저장하는 메서드를 setter
	//인출하는 메서드를 getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		chkName(name);
		this.name = name;
	}
	private void chkName(String name2) {
		// TODO Auto-generated method stub
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
