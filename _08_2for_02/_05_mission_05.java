package _08_2for_02;

public class _05_mission_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*carnum배열의 인덱스가 0인 값부터 주차장에 들어온다. // carnum배열은 자동차 번호를 의미합니다. 
	   parking의 인덱스 번호가 주차번호이다. 
	   자동차 번호의 마지막 번호는 해당 차량이 주차할 주차번호이다.
	   만약 주차번호에 다른 차량이 주차되어 있으면 다음 주차번호에 주차를 한다.
	   (이때, 다음 주차번호에도 차량이 있으면 주차불가이다.)
		주차가 끝난 후 주차번호와 주차항 차량 번호를 출력하시오.*/
		
		int[] carnum = {1232,1221,1235,1252,1234,4536,3457,3238,3229,2599};
		int[] parking = new int[10];
		int num=0;
		for(int i=0;i<carnum.length;i++) {
			num=carnum[i]%10;
			if(num<9) {
				if(parking[num]==0) {
					parking[num]=carnum[i];
				}else if(parking[num+1]==0){
					parking[num+1]=carnum[i];
				}else {
					System.out.println(carnum[i]+" 는 주차불가");
				}
			}else {
				if(parking[num]==0) {
					parking[num]=carnum[i];
				}else {
					System.out.println(carnum[i]+" 는 주차불가");
				}
			}
		}
		for(int i=0;i<parking.length;i++) {
			System.out.println(i+"번 "+parking[i]);
		}
	}

}
