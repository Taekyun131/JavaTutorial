package _05for_03;

public class _06_missioin_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//수식을 연산자 우선순위 무시, 순서대로 계산하는 프로그램 작성
		String a="23-56+45*2-56";//-32
		String c="";
		int d=0;
		int sum=0;
		for(int i=0;i<a.length();i++) {
			char b=a.charAt(i);
			if((int)b>=48&&(int)b<=57) {
				c +=b;
				
			}else {
				d=Integer.parseInt(c);
				sum+=d;
				c=" ";
				sum+=b;
			}
			if(i==a.length()-1) {
				c+=b;
				d=Integer.parseInt(c);
				sum+=d;
			}
		}
		System.out.println(d);
					
			
		
		
			
		
			
			
			
			
		}

}
