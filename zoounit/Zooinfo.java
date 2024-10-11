package zoounit;

public abstract class Zooinfo {//추상 클래스, 추상메서드가 있따면 객체를 만들 수 없다.
	String zooName="휴먼동물원";
	String name=null;
	int age=1;
	int kg=10;
	
	public abstract void prt();//추상 메서드, 구현되지 않은 상태
								//상속받으면 반드시 오버라이드
	@Override
	public String toString() {
		return "Zooinfo [zooName=" + zooName + ", name=" + name + ", age=" + age + ", kg=" + kg + "]";
	}
	public void eat() {
		
	}
	
}
