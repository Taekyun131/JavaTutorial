package _05for_03;

public class _04_mission_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*arr 배열에서 0이 의미하는 것은 공터이다. 
		size는 건물의 크기 이다. 건물은 하나만 짓는다. 공터는 연속적으로 있어야 한다. 
		size 설정값에 따라 공터에 건물을 지을 수 있는 위치는 모두 몇개인가?
		size가 2일경우에 7개이다. */
		int[] arr = {1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,1};
		int size=2;
		int count=1;
		int count2=0;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				count++;
			}else {
				count2=count;
				count=0;
			}
			if(count2>=size) {
				sum+=count2-1;
				count2=0;
			}
		}
		System.out.println(sum);
	}

}
