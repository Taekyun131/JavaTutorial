package _03for;

public class _02_mission {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.1부터 100까지 숫자 중 홀수는 더하고 짝수는 뺸 결과값 출력
		int sum1=0;
		for(int i=0;i<=100;i++) {
			if(i%2!=0) {
				sum1+=i;
			}else {
				sum1-=i;
			}
		}
		System.out.println("(홀수의 합)-(짝수의 합): "+sum1);
		
		//2.1부터 100까지 숫자 중 홀수끼리 더한 값, 짝수끼리 더한 값 각각 출력
		int sum2Odd=0;
		int sum2Even=0;
		for(int i=0;i<=100;i++) {
			if(i%2!=0) {
				sum2Odd+=i;
			}else {
				sum2Even+=i;
			}
		}
		System.out.println("홀수들의 합: "+sum2Odd+"/"+"짝수들의 합: "+sum2Even);
		
		//3.1부터 100까지 숫자중 홀수의 개수
		int countOdd=0;
		for(int i=0;i<=100;i++) {
			if(i%2!=0) {
				countOdd++;
			}
		}
		System.out.println("홀수의 개수: "+countOdd);
		
		//4.100부터 999까지의 모든 숫자의 합 >> ex)453: 4+5+3=12
		int sum4=0;
		for(int i=100;i<1000;i++) {
			int i1=(i/100)%10;
			int i2=(i/10)%10;
			int i3=i%10;
			sum4+=i1+i2+i3;
		}
		System.out.println("100부터 999까지 숫자의 합: "+sum4);
		
		//5.범인=100부터 999까지의 숫자 중 십의 자리수가 3의 배수인 수, 범인 출력
		for(int i=100;i<1000;i++) {
			int i2=(i/10)%10;
			if(i2%3==0&&i2!=0) {
				System.out.println("범인1: "+i);
			}
		}
		
		//6.범인=0부터 100까지 숫자 중 순서대로 합한 값이 44를 넘게하는 숫자, 범인 출력(break 사용금지)
		int sum6=0;
		int you=0;
		for(int i=0;i<=100;i++) {
			sum6+=i;
			if(sum6<=44) {
				you=i;
			}
		}
		System.out.println("범인2: "+(you+1));
		
		//7.System.out.print() 명령어를 사용해 "1+2+3+4+5+6+7+8+9+10=결과값"이 출력되는 코드작성
		//System.out.print()=줄바꿈하지 않고 출력하는 명령어
		String sign="+";
		int sum7=0;
		for(int i=1;i<=10;i++) {
			sum7+=i;
			if(i==10) {
				sign="=";
			}
			System.out.print(i+sign);
		}
		System.out.print(sum7);
		System.out.println();
		
		//8.피보나치 수열의 7번째 항까지의 합을 구해 출력, i는 피보나치수열의 개수
		int fib=1;
		int fib2=0;
		int fibSum=0;
		for(int i=1;i<8;i++) {
			fibSum+=fib;
			fib+=fib2;
			fib2=fib-fib2;
		}
		System.out.println("피보나치 수열의 합: "+fibSum);
				
		//9.i를 피보나치 수로 정의 
		int j=0;
		for(int i=1;i<20;) {
			System.out.print(i+"/");
			i+=j;
			j=i-j;
		}
		System.out.println();
		
		//10.987654321 변수 2개와 for문 한개로 모든 자리수의 합 출력
		int a=987654321;
		int sum10=0;
		for(int i=0;i<=8;i++) {
			sum10+=a%10;
			a=a/10;
			
		}
		System.out.println("sum10: "+sum10);
		
	}

}
