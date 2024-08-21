package _미니프로젝트;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class _00_미니프로젝트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		int y;
		int z;
		int a = 0; // 사람 답
		int answer = 0; // 컴퓨터 답
		int score = 0;
		boolean play = true;

		Scanner in = new Scanner(System.in);
		Random in2 = new Random();
		
		// 아이디, 점수 저장 배열
		String[] ids = new String[3];
		int[] scores = new int[3];

//		Scanner ent = new Scanner(System.in);
//		Scanner ent1 = new Scanner(System.in);

		for (int j = 0; j < 3; j++) {
			play=true;
			score=0;
			
			System.out.println("구구단 게임을 실행합니다...");
			System.out.println();
			System.out.println("아이디를 입력하세요...");
			System.out.println();
			ids[j] = in.nextLine();
			System.out.println("[" + ids[j] + "]" + " 확인.");

			while (play) {
				while (score < 150) {
					for (; score < 150;) {
						for (int i = 0; i < 7; i++) {
							x = in2.nextInt(9) + 1;
							y = in2.nextInt(9) + 1;
							answer = x * y;
							System.out.println();
							System.out.println(x + "X" + y + "= ??");
							a = in.nextInt();
							System.out.println("[" + x * y + "]");
							if (a == answer) {
								System.out.println("정답");
								score += 30;
								System.out.println("점수 : " + score);
							} else {
								System.out.println("오답");
								score -= 15;
								System.out.println("점수 : " + score);
							}
						}
						if (score >= 150) {
							System.out.println("대단합니다 ! 다음 단계로 넘어가겠습니다 !");
							System.out.println("다음 단계로 넘어가시려면 아무키나 입력하세요 !");
							in.nextLine();
							in.nextLine();
							for (int i = 0; i < 7; i++) {
								x = in2.nextInt(9) + 1;
								y = in2.nextInt(9) + 1;
								z = in2.nextInt(9) + 1;
								answer = x * y * z;
								System.out.println();
								System.out.println(x + "X" + y + "X" + z + "= ??");
								a = in.nextInt();
								System.out.println("[" + x * y * z + "]");
								if (a == answer) {
									System.out.println("정답");
									score += 20;
									System.out.println("점수 : " + score);
								} else {
									System.out.println("오답");
									score -= 10;
									System.out.println("점수 : " + score);
								}
							}
							if (score >= 220) {
								System.out.println("대단합니다 ! 이어서 다음 단계로 넘어가겠습니다 !");
								System.out.println("다음 단계로 넘어가시려면 아무키나 입력하세요...");
								in.nextLine();
								in.nextLine();
								for (int i = 0; i < 5; i++) {
									x = in2.nextInt(9) + 1;
									y = in2.nextInt(9) + 1;
									answer = ((x * 10) + y) * x;
									System.out.println();
									System.out.println(((x * 10) + y) + "X" + x);
									a = in.nextInt();
									System.out.println("[" + ((x * 10) + y) * x + "]");
									if (a == answer) {
										System.out.println("정답");
										score += 20;
										System.out.println("점수 : " + score);
									} else {
										System.out.println("오답");
										score -= 10;
										System.out.println("점수 : " + score);
									}
								}
							}
						} else {
							System.out.println("아쉽습니다 ! 다시 도전하시겠습니까 ?");
							System.out.println("다시 도전하시려면 아무키나 입력하세요..");
							in.nextLine();
							in.nextLine();
							score = 0;
							continue;
						}
						play = false;
					}
				}
//				scores[j]=score;
			}
//			System.out.println("게임 종료! 최종 점수:");
//	        for (int i = 0; i < 3; i++) {
//	            System.out.println("아이디: " + ids[i] + ", 최종 점수: " + scores[i]);
//	        }
//
//	        in.close();
		}
	}

}
