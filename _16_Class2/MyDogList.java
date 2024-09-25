package _16_Class2;

public class MyDogList {
	Dog []d=new Dog[5];
	MyDogList(){
		System.out.println("--dog 관리--");
		System.out.println(d[0]);
		if(d[0]!=null) {
			System.out.println(d[0].name);
		}
		d[1]=new Dog();
		System.out.println(d[1]);
		d[2]=d[1];
		System.out.println(d[2]);
		d[3]=new Dog();
		System.out.println(d[3]);
		Dog dd=new Dog();
		d[4]=dd;
		System.out.println(dd);
		System.out.println(d[4]);
		d[1].name="abc";
		System.out.println(d[1].name);
		System.out.println(d[2].name);
		System.out.println(d[3].name);
		
		for(int i=0;i<5;i++) {
			if(d[i]!=null) {
				System.out.println(d[i].name );
			}
		}
		//강아지 검색
		String s="땡칠이";
		for(int i=0;i<5;i++) {
			if(d[i]!=null) {
				if(d[i].name.equals(s)) {
					System.out.println("찾음");
					break;
				}
			}
		}
	}
}
