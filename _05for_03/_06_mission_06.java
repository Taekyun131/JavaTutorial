package _05for_03;

public class _06_mission_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="23-56+45*2-56";//-32
		String c="";
		int d=0;
		char sign='+';
		int result=0;
		for(int i=0;i<a.length();i++) {
			char b=a.charAt(i);
			if(b<48||b>57) {
				d=Integer.parseInt(c);
				c="";
				if(sign=='+') {
					result+=d;
				}else if(sign=='-') {
					result-=d;
				}else if(sign=='*') {
					result*=d;
				}
				sign=b;
			}else {
				c+=b;
			}
		}
		result-=Integer.parseInt(c);
		System.out.println(result);
	}

}
