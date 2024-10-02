package _19_Static_final;

public class Main {
	//접근	공용변수	리턴타입	메서드명 	매개변수
	public static void main(String[] args) {
		String name=Thread.currentThread().getName();
		//스레드가 코드를 실행한다.
		//현재 코드를 실행한느 스레드의 여러 정보중
		//스레드의 이름을 가져온는 메서드
		System.out.println(name+"스레드가 1초뒤에 시작합니다.");
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
//		MemberADM m=new MemberADM();
		
		//static 변수는 공용변수. 위치는 Method area
		//모든 스레드가 공용해서 사용가능=>즉, 변수값 접근가능
		//객체를 만들지 않고 클래스명과 변수 또는 메서드명으로 접근
		String a=MemberADM.companyName;
		System.out.println(a);
		System.out.println(MemberADM.companyName);
		MemberADM.prt();
		MemberADM.companyName="Homan";
		System.out.println(MemberADM.companyName);
		
		/* 새로운 스레드를 만들어서 멀티스레드로 운용가능
		Thread t1=new Thread();
		t1.setName("task1_Thread");
		String tname=t1.getName();
		System.out.println("새로만든 스레드 이름은 "+tname);
		*/
		
	}
	

}
