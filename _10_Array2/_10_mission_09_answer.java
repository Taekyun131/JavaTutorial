package _10_Array2;

import java.util.Random;
import java.util.Scanner;

public class _10_mission_09_answer {

		public static void main(String[] args) {
			// TODO Auto-generated method stub		
			Scanner in = new Scanner(System.in);
			Random r = new Random();
			int[][] pang= {
					{1,1,0,2},
					{3,2,2,2},
					{0,3,3,2},
					{4,4,4,4},
					{2,4,3,1},
					{2,4,1,3}};		
			int maxRow=pang.length;   // 배열의 행의 길이
			int maxCol=pang[0].length;  // 배열의 열의 길이
			                            // 이렇게 하면 배열을 한 번만 참조하여 변수에 저장함
			                            // 변수를 재사용하여 배열의 참조 연산을 줄일 수 있음 > 속도향상
					
			while(true) {
				//배열 출력
				System.out.println("팡팡팡 Game ~!");
				for(int i=0; i< maxRow; i++) {
					System.out.print(i+"번 행 : ");
					for(int j=0; j< maxCol; j++) {
						System.out.print(pang[i][j]+" ");
					}
					System.out.println();
				}
				// 키보드로 좌표 입력
				System.out.println("행번호를 입력하세요 ");
				int row =  in.nextInt();
				in.nextLine();
				System.out.println("열번호를 입력하세요 ");
				int col = in.nextInt();
				in.nextLine();
				
				// 필요 변수 초기값 설정
				int number=pang[row][col];  // 현재 캐릭터의 번호
				int numberLength=0;   // 연속 캐릭터의 수
				int numberLeftCol=col;  // 캐릭터의 왼쪽 시작 번호
				int numberRightCol=col;  // 캐릭터의 오른쪽 시작 번호
				
				// 왼쪽 방향으로  탐색
				for(int i = col ; i >= 0; i--) {
					if(pang[row][i]==number) {
						numberLength++;
						numberLeftCol=i;
					}else {
						break;
					}
				}
				//System.out.println(numberLeftCol);// 디버깅용
				//오른쪽 방향으로 탐색
				for(int i=col+1; i<maxCol; i++) {
					if(pang[row][i]==number) {
						numberLength++;
						numberRightCol=i;
					}else {
						break;
					}
				}
				//System.out.println(numberRightCol);// 디버깅용
				// 왼쪽 오른쪽 탐색 끝 
				// 제거 갯 수
				if(numberLength >= 3) {
					System.out.println(numberLength +"개 제거");
				}
				
				// 행에서 제거 된 만큼 위에 숫자를 한 칸씩 다운하기
				for(int i = numberLeftCol; i <= numberRightCol; i++) {
					for(int j = row-1; j >= 0; j--) {
						pang[j+1][i]=pang[j][i];						
						if(j==0){
							pang[j][i]=9;  //빈칸은 9로 저장
						}
					}
				}
				
				//빈칸 랜덤 숫자 채우기, 
				for(int i=0; i< maxRow; i++) {
					for(int j=0; j< maxCol; j++) {
						if(pang[i][j]==9) {
							pang[i][j]=r.nextInt(5);
						}
					}
				}
				
			}
	}

}
