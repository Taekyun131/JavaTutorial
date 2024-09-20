package _13_Class_mission2;

import java.util.Scanner;

public class TrainMg {
	TrainReg [] trainList=new TrainReg[5];
	int length=trainList.length;
	Scanner in=new Scanner(System.in);
	TrainMg(){
		while(true) {
			menu();
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				System.out.println("1. 기차시간 등록하기를 선택");
				addTrain();
			}else if(selNum==2) {
				System.out.println("2. 기차시간 전체보기를 선택");
				allTrain();
			}else if(selNum==3) {
				System.out.println("3. 기차시간 수정하기를 선택");
				modTrain();
			}else if(selNum==4) {
				System.out.println("4. 기차 수리정보 보기를 선택");
				fixTrain();
			}else {
				continue;
			}
		}
	}
	//0. 메뉴
	public void menu() {
		System.out.println("*****번호를 선택하세요*****");
		System.out.println("1. 기차시간 등록하기");
		System.out.println("2. 기차시간 전체보기");
		System.out.println("3. 기차시간 수정하기");
		System.out.println("4. 기차 수리정보보기");
		System.out.println(">>>");
	}
	
	//1. 등록하기
	public void addTrain() {
		TrainReg train=new TrainReg();
		System.out.println("기차번호를 입력하세요");
		train.TrainNum=in.nextInt();
		in.nextLine();
//		System.out.println("기차시간을 입력하세요");
//		train.TrainTime=in.nextLine();
//		for(int i=0;i<trainList.length;i++) {
//			if(trainList[i]==null) {
//				trainList[i]=train;
//				break;
//			}
//		}
		
		
		if(train.TrainNum==1111||train.TrainNum==3333) {
			train.TrainType="무궁화";
			System.out.println("도착시간을 입력하세요");
			train.TrainTime=in.nextLine();
			for(int i=0;i<length;i++) {
				if(trainList[i]==null) {
					trainList[i]=train;
					break;
				}
			}
		}else if(train.TrainNum==2222||train.TrainNum==4444) {
			train.TrainType="새마을";
			System.out.println("도착시간을 입력하세요");
			train.TrainTime=in.nextLine();
			for(int i=0;i<length;i++) {
				if(trainList[i]==null) {
					trainList[i]=train;
					break;
				}
			}
		}else {
			System.out.println("해당 기차가 없습니다.");
		}
		
//		System.out.println("도착시간을 입력하세요");
//		train.TrainTime=in.nextLine();
//		in.nextLine();
//		for(int i=0;i<trainList.length;i++) {
//			if(trainList[i]==null) {
//				trainList[i]=train;
//				break;
//			}
//		}
	}
	
	
	//2. 전체보기
	public void allTrain() {
		for(int i=0;i<length;i++) {
			if(trainList[i]!=null) {
				trainList[i].showTrain();
			}
		}
	}
	
	
	//3. 수정하기
	public void modTrain() {
		System.out.println("수정할 기차번호를 입력하세요");
		int modTrainNumber=in.nextInt();
		in.nextLine();
//		for(int i=0;i<trainList.length;i++) {
//			if(trainList[i]!=null) {
//				if(trainList[i].TrainNum==modTrainNumber) {
//					String modTrainTime=in.nextLine();
//					System.out.println("기차의 수정된 시간을 입력학세요");
//					trainList[i].TrainTime=modTrainTime;
//					break;
//				}
//			}
//		}
		for(int i=0;i<length;i++) {
			if(trainList[i]!=null) {
				if(trainList[i].TrainNum==modTrainNumber) {
					System.out.println("기존 도착시간을 입력하세요");
					String TrainTime=in.nextLine();
					if(trainList[i].TrainTime.equals(TrainTime)) {
						System.out.println("수정된 도착시간을 입력하세요");
						String modTrainTime=in.nextLine();
						trainList[i].TrainTime=modTrainTime;
						break;
					}
				}
			}
		}
	}
	//수리중기차메뉴
	public void fixTrain() {
		while(true) {
			System.out.println("-----번호를 선택하세요-----");
			System.out.println("1. 기차 수리등록");
			System.out.println("2. 수리중인 기차보기");
			System.out.println("3. 나가기");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				System.out.println("수리할 기차번호를 등록하세요");
				int fixTrainNum=in.nextInt();
				if(fixTrainNum%1111==0) {
					for(int i=0;i<length;i++) {
						if(trainList[i]!=null) {
							if(trainList[i].TrainNum==fixTrainNum){
								trainList[i].TrainState="수리중";
										break;
							}
						}
					}
				}else {
					System.out.println("기차번호를 다시 입력하세요");
				}
			}else if(selNum==2) {
				for(int i=0;i<length;i++) {
					if(trainList[i]!=null) {
						trainList[i].showFixTrain();
					}
				}
			}else {
				break;
			}
		}
	}
}
