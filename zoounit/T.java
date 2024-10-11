package zoounit;

public class T extends Zooinfo{
	@Override	//선택적으로 재정의
	public void eat() {
		System.out.println("닭한마리 먹기");
	}

	@Override	//필수적으로 재정의
	public void prt() {
		// TODO Auto-generated method stub
		
	}
	
}
