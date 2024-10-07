package _21_Exception;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//바이너리 코드가 실행이 되면
		//jvm의 코드영역에 소스가 로딩이 되고
		//스레드가 생성되어 main메서드 코드를 실행한다.
		//new는 객체를 만들고 객체의 주소를 리턴받는다.
		//new 연산자 뒤에는 생성자를 작성한다.
		//생성자로 객체를 만들고, 생성자(메서드)를 호출한다.
		//생성자 메서드의 모든 코드가 종료되면 호출위치로 리턴
		new MemberAdmin();
	}

}
