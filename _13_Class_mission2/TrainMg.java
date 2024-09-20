package _13_Class_mission2;

import java.util.Scanner;

public class TrainMg {
	TrainReg [] trainList=new TrainReg[5];
	Scanner in=new Scanner(System.in);
	TrainMg(){
		while(true) {
			menu();
			int selNum=in.nextInt();
			if(selNum==1) {
				System.out.println("1. 기차시간 등록하기를 선택");
				addTrain();
			}else if(selNum==2) {
				System.out.println("2. 기차시간 전체보기를 선택");
				allTrain();
			}else if(selNum==3) {
				System.out.println("3. 기차시간 수정하기를 선");
				modTrain();
			}else if(selNum==4) {
				
			}else {
				break;
			}
		}
	}
	public void menu() {
		System.out.println("*****번호를 선택하세요*****");
		System.out.println("1. 기차시간 등록하기");
		System.out.println("2. 기차시간 전체보기");
		System.out.println("3. 기차시간 수정하기");
		System.out.println(">>>");
	}
	public void addTrain() {
		
		System.out.println("기차번호를 입력하세요");
		String newTrainNum=in.nextLine();
		System.out.println("기차시간을 입력하세요");
		String newTrainTime=in.nextLine();
		for(int i=0;i<trainList.length;i++) {
			if(trainList[i]==null) {
				
			}
		}
	}
	public void allTrain() {
		
	}
	public void modTrain() {
		
	}
}
