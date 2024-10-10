package humanzoo;

public class Animal {
	public String name=null;
	public int age=0;
	public int weight=0;
	
	public void eat() {
		System.out.println("먹이를 먹는다.");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
}
