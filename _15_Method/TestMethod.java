package _15_Method;

public class TestMethod {
	//생성자는 눈에 안보이지만 생략되어 있음
	String name=null;
	
	//이름뒤에 마스킹을 해주는 메서드 만들기
	//호출할 때 문자열로 마스킹 문자를 지정하면,
	//이름뒤에 마스킹 문자를 연결하여 리턴한다.
	//메서드명은 maskName
	public String maskName(String mark) {
		return name+mark;
	}
	
	public String getName2(String pwd) {
		if(pwd.equals("1111")) {
			return name;
		}else {
			return null;
		}
	}
	
	public void setName(String n) {
		name=n;
	}
	
	public String getName() {
		return name;
	}
}
