package zoounit;

import java.util.ArrayList;

public class Zooplay {

	public static void main(String[] args) {
		ArrayList<Zooinfo> zlist=new ArrayList<>();
		Zooinfo z=new T();
		z.name="호돌이";
		z.age=1;
		z.kg=40;
		zlist.add(z);
		z=new T();
		z.name="호순이";
		z.age=2;
		z.kg=60;
		zlist.add(z);
		z=new M();
		z.name="숭이";
		z.age=3;
		z.kg=30;
		zlist.add(z);
		for(Zooinfo zz:zlist) {
			zz.eat();
		}
		for(Zooinfo zz:zlist) {
			System.out.println(zz.toString());
		}
		
	}

}
