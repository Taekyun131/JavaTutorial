package _13_Class_mission2_answer;

import java.util.Scanner;

public class T_Center {
	T_one[] tlist=new T_one[5];
	public T_Center() {
		Scanner in=new Scanner(System.in);
		while (true) {
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 전체보기");
			System.out.println("4. 종료");
			System.out.println("메뉴선택>>");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				add();
			}else if(selNum==2) {
				mod();
			}else if(selNum==3) {
				listAll();
			}else if(selNum==4) {
				break;
			}
		}
	}
	public void add() {
		//기차시간을 추가
		//T_one객체를 생성하고 기차번호와 시간을 입력
		Scanner in=new Scanner(System.in);
		T_one tempT=new T_one();
		System.out.println("기차번호를 입력하세요");
		tempT.tNum=in.nextLine();
		System.out.println("기차시간을 1203형식으로 입력");
		tempT.tTime=in.nextLine();
		
		//배열의 빈칸에 저장, 빈칸은 배열의 값이 null
		for (int i=0;i<tlist.length;i++) {
			if(tlist[i]==null) {
				tlist[i]=tempT;
				break;
			}
		}
		
	}
	public void mod() {
		System.out.println("수정할 기차번호 입력");
		Scanner in=new Scanner(System.in); 
		String modNum=in.nextLine();
		//조건을 걸어본다. 기차번호는 유니크하다.
		for(int i=0;i<tlist.length;i++) {
			String mnum=tlist[i].getTnum();
			if(mnum.equals(modNum)) {
//			if(tlist[i].tNum.equals(modNum)) {
				//기차번호가 유니크하다는 것은
				//뒤에 있는 기차번호가 중복될 수 없다.
				//그래서 바로 수정이 가능하다.
				System.out.println("수정시간 입력");
				tlist[i].tTime=in.nextLine();
				break;
			}
		}
	
	}
	public void listAll() {
		for(int i=0;i<tlist.length;i++) {
			if(tlist[i]!=null) {
				tlist[i].prt();
			}
		}
	}
	
}
