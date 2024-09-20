package _13_Class_mission2;

public class TrainReg {
	int TrainNum=0;
	String TrainTime=null;
	String TrainType=null;
	String TrainState=null;
	TrainReg(){
		
	}
	//일반기차 전체보기
	public void showTrain() {
		if(TrainState!="수리중") {
			//기차이름
			int trainName=TrainNum/1111;
			System.out.println("기차이름: "+trainName+"번열차");
//		if(TrainNum==1111) {
//			System.out.println("기차이름: 1번열차");
//		}else if(TrainNum==2222) {
//			System.out.println("기차이름: 2번열차");
//		}else if(TrainNum==3333) {
//			System.out.println("기차이름: 3번열차");
//		}else if(TrainNum==4444) {
//			System.out.println("기차이름: 4번열차");
//		}
			
			//기차번호
			System.out.println("기차번호: "+TrainNum);
//		System.out.println("기차종류: "+TrainType);
			
			//기차종류
			if(TrainType=="새마을") {
				System.out.println("기차종류: "+TrainType+"*");
			}else {
				System.out.println("기차종류: "+TrainType);
			}
			
			//도착시간
			System.out.println("도착시간: "+TrainTime);
			System.out.println();
		}
	}
	
	
	
	//수리중 기차보기
	public void showFixTrain() {
		if(TrainState=="수리중") {
			
			//기차이름
			int trainName=TrainNum/1111;
			System.out.println(trainName+"번열차");
			
			//기차번호
			System.out.println("기차번호: "+TrainNum);
			
			
			//기차종류
			if(TrainType=="새마을") {
				System.out.println("기차종류: "+TrainType+"*");
			}else {
				System.out.println("기차종류: "+TrainType);
			}
			
			//도착시간
			System.out.println("도착시간: "+TrainTime);
			System.out.println();
		}
		}
	
}
