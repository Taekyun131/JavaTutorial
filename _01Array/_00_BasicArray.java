package _01Array;

public class _00_BasicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//내용: 자바의 배열
		/*특징: 변수 하나로 여러 개의 값을 저장함
		 *     같은 자료형을 연속적으로 저장(나중에는 다른 자료형도 저장할 수 있는 것 배울 예정)
		 *     고정길이 - 사용하지 않은 index가 있을 수도 있고 
		 *             길이가 짧아서 데이터를 다 저장하지 못할 수도 있음
		 *             단, 속도는 빠름
		 *공부할 때: 배열의 길이, 배열의 인덱스 기억하자!
		 */
//		배열 선언문
		int[]lotto=new int[3]; //길이 3, 인덱스 0-2, value type: int 
		System.out.println(lotto[0]+"/"+lotto[1]+"/"+lotto[2]);
		lotto[1]=30;
		lotto[0]=20;
		lotto[2]=40;
		System.out.println(lotto[0]+"/"+lotto[1]+"/"+lotto[2]);
		lotto[0]=lotto[1]+lotto[2];
		System.out.println(lotto[0]+"/"+lotto[1]+"/"+lotto[2]);
		System.out.println(lotto[0]+20);
		System.out.println(lotto[0]+"/"+lotto[1]+"/"+lotto[2]);
		lotto[3]=lotto[1]+20;//3번 인덱스가 없음.
							//예외발생 ArrayIndexOutofBoundsException
	}

}
