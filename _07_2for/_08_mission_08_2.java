package _07_2for;

public class _08_mission_08_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*애니팡 게임의 일부분인다. 게임의 캐릭터는 숫자로 구분한다.
		가로에 같은 캐릭터가 3개 이상이면 제거 대상이다.
		제거 대상 캐릭터 번호와 갯수, 시작위치 인덱스를 모두 출력하시오. 
		-이중 for  사용*/
		
		int[] pang={1,0,0,0,2,3,4,4,6,2,2,2,2,5};
		int count=0;
		int nowNum=0;
		int targetNum=0;
		int start=0;
		for(int i=0;i<pang.length;i++) {
			nowNum=pang[i];
			count=0;
			for(int j=i;j<pang.length;j++) {
				if(pang[j]==nowNum) {
					count++;
				}else {
					break;
				}
			}
			if(count>=3) {
				targetNum=nowNum;
				start=i;
				System.out.println("제거대상: "+targetNum+" 갯수: "+count+" 시작위치: "+start);
			}
			i=i+count-1;
		}
	}
}
		


