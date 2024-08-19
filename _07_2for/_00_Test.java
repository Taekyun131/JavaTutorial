package _07_2for;

public class _00_Test {

	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			System.out.println("1*"+i+"="+(1*i));
		}
		
		for(int dan=1;dan<5;dan++) {
			System.out.println(dan);
			for(int i=0;i<5;i++) {
				System.out.println(dan+"*"+i+"="+(dan*i));
			}
		}
	}

}
