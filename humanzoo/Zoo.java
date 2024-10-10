package humanzoo;

import java.util.ArrayList;


public class Zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Animal>alist=new ArrayList<>();
		Tiger t1=new Tiger();
		t1.name="호돌이";
		t1.age=1;
		t1.weight=40;
		alist.add(t1);
		
		Tiger t2=new Tiger();
		t2.name="호순이";
		t2.age=2;
		t2.weight=60;
		alist.add(t2);
		
		Monkey m1=new Monkey();
		m1.name="숭이";
		m1.age=3;
		m1.weight=30;
		alist.add(m1);
		
		for(Animal a:alist) {
			System.out.println(a.toString());
			a.eat();
		}
			
			
		
		
	}

}
