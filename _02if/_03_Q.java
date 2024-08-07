package _02if;

public class _03_Q {
 public static void main(String[] args) {
	 //문제 1
	 double avg=89.2;
	 if(avg>=80) {
		 System.out.println("합격");
	 }else {
		 System.out.println("불합격");
	 }
	 
	//문제 2
	 int level =2;
	 int point =30;
	 if(level==1) {
		 point+=30;
	 }else {
		 point+=10;
	 }
	 System.out.println(point);
	 
	 //문제 3
	 int [] lotto= {6,12,33,4,5,26};
	 System.out.println(lotto[2]+80);
	 
	 //문제 4
	 if((lotto[3]%2)==0) {
		 System.out.println("짝수");
	 }else {
		 System.out.println("홀수");
	 }
	 
	 //문제 5
	 int sum=0;
	 if ((lotto[0]%2)!=0) {
		 sum+=lotto[0];
	 }
	 if ((lotto[1]%2)!=0) {
		 sum+=lotto[1];
	 }
	 if ((lotto[2]%2)!=0) {
		 sum+=lotto[2];
	 }
	 if ((lotto[3]%2)!=0) {
		 sum+=lotto[3];
	 }
	 if ((lotto[4]%2)!=0) {
		 sum+=lotto[4];
	 }
	 if ((lotto[5]%2)!=0) {
		 sum+=lotto[5];
	 }
	 System.out.println(sum);
	 
	 //문제 6
	 int [] a= {45,34,64,45,24};
	 int sumArray=a[0]+a[1]+a[2]+a[3]+a[4];
	 System.out.println(sumArray);
	 
	 //문제 7
	 int [] a2= {45,34,64};
	 int a20Sum=(a2[0]/10)+(a2[0]%10);
	 int a21Sum=(a2[1]/10)+(a2[1]%10);
	 int a22Sum=(a2[2]/10)+(a2[2]%10);
	 if ((a20Sum>=a21Sum)&&(a20Sum>=a22Sum)) {
		 System.out.println("선택할 숫자: 0번째"+" 숫자의 합: "+a20Sum );
	 }else if(a21Sum>=a22Sum) {
		 System.out.println("선택할 숫자: 1번째"+" 숫자의 합: "+a21Sum);
	 }else {
		 System.out.println("선택할 숫자: 2번째"+" 숫자의 합: "+a22Sum);
	 }
	 
	 //문제 8
	 int [] x= {6,5,9};
	 int [] y= {4,10,6};
	 int [] bullet= {3,2};
	 double gradientBullet=bullet[1]/bullet[0];
	 double gradientBird0=y[0]/x[0];
	 double gradientBird1=y[1]/x[1];
	 double gradientBird2=y[2]/x[2];
	 
	 if(gradientBullet==gradientBird0) {
		 System.out.println("총알에 맞는 새는 0번입니다.");
	 }
	 if(gradientBullet==gradientBird1) {
		 System.out.println("총알에 맞는 새는 1번입니다.");
	 }
	 if(gradientBullet==gradientBird2) {
		 System.out.println("총알에 맞는 새는 2번입니다.");
	 }
	 
	 
	 
 }
}
