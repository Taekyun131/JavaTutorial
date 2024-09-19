package _13_Class_mission;

import java.util.Scanner;

public class Car_m {
	Car_obj [] allCar=new Car_obj[7]; 
	Scanner in=new Scanner(System.in);
	boolean insert=true;
	Car_m(){
		while(true) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 차량등록");
			System.out.println("2. 차량조회");
			System.out.println("3. 등록차량 전체조회");
			System.out.println("4. 등록차량 삭제");
			int selNum=in.nextInt();
			in.nextLine();
			System.out.println(selNum+"을 선택");
			if(selNum==1) {
				addCar();
			}else if(selNum==2) {
				myCar();
			}else if(selNum==3) {
				showCar();
			}else if(selNum==4) {
				delCar();
			}else {
				continue;
			}
		}
	}
	
	public void addCar() {
		Scanner in=new Scanner(System.in);
		System.out.println("-----차량등록-----");
		Car_obj car=new Car_obj();
		System.out.println("차량번호 4자리를 입력하세요");
		car.carNum=in.nextInt();
		in.nextLine();
		if(car.carNum<1000||car.carNum>9999) {
			System.out.println("차량번호를 다시 입력하세요");
		}else {
			System.out.println("차량 소유자의 이름을 입력하세요");
			car.name=in.nextLine();
			for(int i=0;i<allCar.length;i++) {
				if(allCar[i]==null) {
					allCar[i]=car;
					break;
				}
			}
		}
	}
	public void myCar() {
		Scanner in=new Scanner(System.in);
		System.out.println("-----차량조회-----");
		System.out.println("조회할 차량번호를 입력하세요");
		int carNumIn=in.nextInt();
		in.nextLine();
		for(int i=0;i<allCar.length;i++) {
			if(allCar[i]!=null&&allCar[i].carNum==carNumIn) {
				System.out.println("차량번호: "+allCar[i].carNum);
				System.out.println("이름: "+allCar[i].name);
			}
		}
		
		
	}
	public void showCar() {
		System.out.println("-----전체등록차량 조회-----");
		for(int i=0;i<allCar.length;i++) {
			if(allCar[i]!=null) {
				allCar[i].prt();
			}
		}
	}
	
	public void delCar() {
		Scanner in=new Scanner(System.in);
		System.out.println("-----등록차량 삭제-----");
		System.out.println("삭제할 차량번호를 입력하세요");
		int delCarNum=in.nextInt();
		in.nextLine();
		for(int i=0;i<allCar.length;i++) {
			if(allCar[i]!=null&&allCar[i].carNum==delCarNum) {
				allCar[i]=null;
			}
		}
	}
}
