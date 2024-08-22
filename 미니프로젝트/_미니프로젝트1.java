package _미니프로젝트;

import java.util.Random;
import java.util.Scanner;

public class _미니프로젝트1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x; // 구구단의 변수
		int y; // 구구단의 변수
		int z; // 구구단의 변수
		int a = 0; // 사람 답
		int answer = 0; // 컴퓨터 답
		int score = 0; // 사용자의 점수
		boolean play, retry; // 진행과 재시작 여부 제어 변수

		Scanner in = new Scanner(System.in);
		Random in2 = new Random();

		// 아이디, 점수 저장 배열
		String[] ids = new String[3]; // 3명의 아이디 저장 배열
		int[] scores = new int[3]; // 3명의 플레이어에 대한 점수 저장 배열
		int tempMaxIndex = 0; // 3명의 점수 오름차순

		// 3명에 한해 게임 실행
		// retry (게임이 진행중일때 계속 실행)
		// 3명의 점수를 scores 배열에 저장하고 끝나면 최종점수를 출력한다.
		for (int j = 0; j < 3; j++) {
			tempMaxIndex = 0;
			retry = true;
			while (retry) {
				score = 0;
				play = true;
				System.out.println("구구단 게임을 실행합니다...");
				System.out.println();
				System.out.println("아이디를 입력하세요...");
				System.out.println();
				ids[j] = in.nextLine();
				System.out.println("[" + ids[j] + "]" + " 확인.");

				// 구구단 7문제를 랜덤으로 생성한다.
				while (play) {
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
					// 점수가 150점 이상일때 다음단계로 넘어간다.
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
						// 점수가 220점 이상일때 다음단계로 넘어감
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
							// 3단계가 끝나면 점수가 맘에 안들면 다시 도전할지 묻는다.
							// 사용자가 n이라고 답하면 점수 저장, y라고 답하면 게임을 처음부터 다시 시작한다.
							System.out.println("축하합니다! 3단계를 완료했습니다!");
							System.out.println("다시 도전하시겠습니까? (y/n)");
							in.nextLine();
							String response = in.nextLine();
							if (response.equalsIgnoreCase("n")) {
								play = false;
								retry = false;
							}
						} else {
							// 220 미만일 때 실행
							System.out.println("아쉽습니다 ! 다시 도전하시겠습니까 ?");
							System.out.println("다시 도전하시려면 아무키나 입력하세요..");
							in.nextLine();
							in.nextLine();
							score = 0;
							continue;
						}
					} else {
						// 150 미만일 때 실행
						System.out.println("아쉽습니다 ! 다시 도전하시겠습니까 ?");
						System.out.println("다시 도전하시려면 아무키나 입력하세요..");
						in.nextLine();
						in.nextLine();
						score = 0;
						continue;
					}
				}
				// 3명의 점수를 최종 출력
				scores[j] = score;
				System.out.println("게임 종료! 최종 점수:");
				for (int i = 0; i < 3; i++) {
					System.out.println("아이디: " + ids[i] + ", 최종 점수: " + scores[i]);
				}
				for (int i = 0; i < scores.length-i; i++) {
					if (scores[tempMaxIndex] < scores[i]) {
						tempMaxIndex = i;
					}
					int temp = scores[scores.length - 1-i];
					scores[scores.length - 1-i] = scores[tempMaxIndex];
					scores[tempMaxIndex] = temp;
				}
			}
		}
		for (int k = 0; k < scores.length; k++) {
			System.out.println("[" + (k + 1) + "위] : " + scores[k] + " /" + "아이디 : " + ids[k]);
		}
		// 샘이 이거 쓰는게 좋다고 함.
		in.close();
	}
}
