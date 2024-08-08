package _03for;

public class _01_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {30,40,50,55,65};
		//배열순회를 반복하면서 값의 조건판단 후 출력
		//50이상인 값만 출력(정제)
		for (int i=0;i<5;i++) {
			if(a[i]>=50) {
				System.out.println(a[i]);
			}
		}
		
		//50점 이상 점수를 합하시오.
		int sum=0;
		for(int i=0;i<5;i++) {
			if(a[i]>=50) {
				sum+=a[i];
			}
		}
		System.out.println("50점 이상 점수의 합: "+sum);
		
		//평균을 구하시오. 단, 50점이상만
		int sum1=0;
		int count1=0;
		for(int i=0;i<5;i++) {
			if(a[i]>=50) {
				sum1+=a[i];
				count1++;
			}	
		}
		System.out.println("50점 이상 점수의 평균: "+(double) sum1/count1);
		
		//평균을 구하시오. 단, 최저점수는 포함하지마시오
		int sum2=0;
		int count2=0;
		int minVal=100;
		for(int i=0;i<5;i++) {
			if(a[i]<minVal) {
				minVal=a[i];
			}
			sum2+=a[i];
			count2++;
		}
		sum2=sum2-minVal;
		System.out.println("최저점수를 포함하지 않는 평균: "+(double)sum2/(count2-1));
		
		//for문 두개
//				for(int i=0;i<5;i++) {
//				if(a[i]<minVal) {
//					minVal=a[i];
//					}
//				}
//				for(int i=0;i<5;i++) {
//					if(minVal!=a[i]) {
//						sum2+=a[i];
//						count2++;
//					}
//				}
	}

}
