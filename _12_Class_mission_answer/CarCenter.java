package _12_Class_mission_answer;

import java.util.Scanner;

public class CarCenter {
	CarOne [] carList=new CarOne[7];
	Scanner in=new Scanner(System.in);
	CarCenter(){
		
	}
	public void carAdd(){
		
	}
	public void carMod(){
		//시나리오 정의
		//번호로 수정할 자동차 객체를 찾는다.
		//번호는 수정이불가능/삭제만 할 수 있고, 소유자만 수정이 가능
		System.out.println("수정할 자동차 번호 입력");
		String modNumber=in.nextLine();
		//객체찾기		>> 배열순회 필요
		for(int i=0;i<carList.length;i++) {
			if(carList[i]!=null) {
				if(carList[i].carNumber.equals(modNumber)) {
					System.out.println("소유자의 이름을 입력");
					String newUser=in.nextLine();
					//입력된 값의 유효성을 체크하는 등
					//무결성 코드 추가가능
					carList[i].carUser=newUser;
					break;
				}
			}
		}
	}
	
	public void carDel() {
		//시나리오 정의
		//번호로 삭제할 자동차 객체를 찾느느다. 그리고 삭제
		System.out.println("삭제할 자동차 번호 입력");
		String delNumber=in.nextLine();
		for(int i=0;i<carList.length;i++) {
			if(carList[i]!=null) {
				if(carList[i].carNumber.equals(delNumber)) {
					carList[i]=null;
					break;
				}
			}
		}
	}
	
}
