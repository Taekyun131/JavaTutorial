package _05for_03;

public class _13_mission_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*문자열 a는 한자릿수의 숫자를 수집한 문자열이다.
		숫자별로 수집된 수만큼 카운팅하세요.
		카운팅 배열은
		int[] a = new int[10]; 
		위 선언문은 길이 10의 배열을 생성한 선언문이다. 초기값은 0이다.
		인덱스 0 - 9까지를 숫자로 정의한다.
		조건 : 형변환은 사용하지 않는다. 메서드는  charAt()만 사용한다.*/
		
		String a = "6/4/3/2/5/1/4/5/6/7/8/9/1/2/3/4/5/6";
		int []count=new int [10];
		for(int i=0;i<a.length();i+=2) {
			char b=a.charAt(i);
			if(b=='0') {
				count[0]++;
			}else if(b=='1') {
				count[1]++;
			}else if(b=='2') {
				count[2]++;
			}else if(b=='3') {
				count[3]++;
			}else if(b=='4') {
				count[4]++;
			}else if(b=='5') {
				count[5]++;
			}else if(b=='6') {
				count[6]++;
			}else if(b=='7') {
				count[7]++;
			}else if(b=='8') {
				count[8]++;
			}else {
				count[9]++;
			}
		
			
		}
		System.out.println("0: "+count[0]);
		System.out.println("1: "+count[1]);
		System.out.println("2: "+count[2]);
		System.out.println("3: "+count[3]);
		System.out.println("4: "+count[4]);
		System.out.println("5: "+count[5]);
		System.out.println("6: "+count[6]);
		System.out.println("7: "+count[7]);
		System.out.println("8: "+count[8]);
		System.out.println("9: "+count[9]);
			
		}
		
	}


