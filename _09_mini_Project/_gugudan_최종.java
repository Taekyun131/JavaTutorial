package _09_mini_Project;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class _gugudan_최종 {
		//색상 추가
	 	public static final String black    = "\u001B[30m" ;
	    public static final String red      = "\u001B[31m" ;
	    public static final String green    = "\u001B[32m" ;
	    public static final String yellow   = "\u001B[33m" ;
	    public static final String blue     = "\u001B[34m" ;
	    public static final String purple   = "\u001B[35m" ;
	    public static final String cyan     = "\u001B[36m" ;
	    public static final String white     = "\u001B[37m" ;
	    public static final String exit     = "\u001B[0m" ;
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x; // 구구단의 변수
		int y; // 구구단의 변수
		int z; // 구구단의 변수
		int a = 0; // 사람 답
		int answer = 0; // 컴퓨터 답
		int score = 0; // 사용자의 점수
		boolean play, retry; // 진행과 재시작 여부 제어 변수
		Timer timer1=new Timer();
		

		Scanner in = new Scanner(System.in);
		Random in2 = new Random();

		// 아이디, 점수 저장 배열
		String[] ids = new String[3]; // 3명의 아이디 저장 배열
		int[] scores = new int[3]; // 3명의 플레이어에 대한 점수 저장 배열

		// 3명에 한해 게임 실행
		// retry (게임이 진행중일때 계속 실행)
		// 3명의 점수를 scores 배열에 저장하고 끝나면 최종점수를 출력한다.
		for (int j = 0; j < 3; j++) {
			retry = true;
			while (retry) {
				score = 0;
				play = true;
				System.out.println("구구단 게임을 실행합니다...");
				System.out.println("⎛⎝(•‿•)⎠⎞⎛⎝(•‿•)⎠⎞⎛⎝(•‿•)⎠⎞⎛⎝(•‿•)⎠⎞");
				System.out.println("아이디를 입력하세요...");
				System.out.println();
				ids[j] = in.nextLine();
				System.out.println("[" + ids[j] + "]" + " 확인.");

				// 구구단 7문제를 랜덤으로 생성한다.
				while (play) {
					score=0;
					long start1 = System.currentTimeMillis(); //시작시간
					long end1 = start1 + 20 * 1000; //끝나는 시간=현재시간+20초
					while (System.currentTimeMillis() < end1) {
						//task1=남은 시간 표시
						TimerTask task1=new TimerTask() {
							public void run() {
								if((end1-System.currentTimeMillis())/1000>0) {
									System.out.print(cyan+"--"+(end1-System.currentTimeMillis())/1000+"--"+exit);
									
								}
							}
						};timer1.schedule(task1, 1000,1000);//task1이 1초뒤에 1초마다 반복실행
						for (int i = 0; i < 7; i++) {
							//시간초과시 구구단 종료
							if (System.currentTimeMillis() >= end1) {
								System.out.println(purple+"시간초과"+exit);
								break;
							}
							x = in2.nextInt(9) + 1;
							y = in2.nextInt(9) + 1;
							answer = x * y;
							System.out.println();
							System.out.println(x + "X" + y + "= ??");
							a = in.nextInt();
							System.out.println("[" + x * y + "]");
							if (a == answer) {
								System.out.println(yellow+"정답"+exit);
								System.out.println(yellow+"⎝㋡⎠"+exit);
								score += 30;
								System.out.println("점수 : " + score);
							} else {
								System.out.println(red+"오답"+exit);
								score -= 15;
								System.out.println("점수 : " + score);
							}
						}
						task1.cancel();
						break;
					}
					// 점수가 150점 이상일때 다음단계로 넘어간다.
					
					if (score >= 150) {
						System.out.println("대단합니다 ! 다음 단계로 넘어가겠습니다 !");
						System.out.println("다음 단계로 넘어가시려면 아무키나 입력하세요 !");
						in.nextLine();
						in.nextLine();
						long start2 = System.currentTimeMillis();
						long end2 = start2 + 25* 1000;
						while (System.currentTimeMillis() < end2) {
							TimerTask task2=new TimerTask() {
								public void run() {
									if((end2-System.currentTimeMillis())/1000>0) {
										System.out.print(cyan+"--"+(end2-System.currentTimeMillis())/1000+"--"+exit);
									}
								}
							};timer1.schedule(task2, 1000,1000);
							for (int i = 0; i < 7; i++) {
								if (System.currentTimeMillis() >= end2) {
									System.out.println(purple+"시간초과"+exit);
									break;
								}
								x = in2.nextInt(30) + 10;
								y = in2.nextInt(5) + 1;
								answer = x * y  ;
								System.out.println();
								System.out.println(x + "X" + y +   "= ??");
								a = in.nextInt();
								System.out.println("[" + x * y  + "]");
								if (a == answer) {
									System.out.println(yellow+"정답"+exit);
									System.out.println(yellow+"⎝㋡⎠"+exit);
									score += 20;
									System.out.println("점수 : " + score);
								} else {
									System.out.println(red+"오답"+exit);
									score -= 10;
									System.out.println("점수 : " + score);
								}
							}
							task2.cancel();
							break;
						}
						// 점수가 220점 이상일때 다음단계로 넘어감
						if (score >= 220) {
							
							System.out.println("대단합니다 ! 이어서 다음 단계로 넘어가겠습니다 !");
							System.out.println("다음 단계로 넘어가시려면 아무키나 입력하세요...");
							in.nextLine();
							in.nextLine();
							long start3=System.currentTimeMillis();
							long end3=start3+25*1000;
							while(System.currentTimeMillis()<end3) {
								TimerTask task3=new TimerTask() {
									public void run() {
										if((end3-System.currentTimeMillis())/1000>=0) {
											System.out.print(cyan+"--"+(end3-System.currentTimeMillis())/1000+"--"+exit);
										}
									}
								};timer1.schedule(task3, 1000,1000);
								for (int i = 0; i < 5; i++) {
									if(System.currentTimeMillis()>end3) {
										System.out.println(purple+"시간초과"+exit);
										break;
									}
									x = in2.nextInt(5) + 2;
									y = in2.nextInt(6) + 4;
									z=in2.nextInt(6)+4; 
									answer =x  * y * z;
									System.out.println();
									System.out.println(x +"X"  + y + "X" + z);
									a = in.nextInt();
									System.out.println("["+answer+"]");
									if (a == answer) {
										System.out.println(yellow+"정답"+exit);
										System.out.println(yellow+"⎝㋡⎠"+exit);
										score += 20;
										System.out.println("점수 : " + score);
									} else {
										System.out.println(red+"오답"+exit);
										score -= 10;
										System.out.println("점수 : " + score);
									}
								}
								task3.cancel();
								break;
							}
							// 3단계가 끝나면 점수가 맘에 안들면 다시 도전할지 묻는다.
							// 사용자가 n이라고 답하면 점수 저장, y라고 답하면 게임을 처음부터 다시 시작한다.
							System.out.println("축하합니다! 3단계를 완료했습니다!");
							System.out.println(green + "다시 도전하시려면 아무키를 입력하시고 저장을 원하시면 '저장'을 입력하세요." + exit);
//							String response1 = in.nextLine();
//							if(response1.equalsIgnoreCase("y")) {
							in.nextLine();
//								play=true;
//							}
							String response = in.nextLine();
							if (response.equalsIgnoreCase("저장")) {
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
				//배열에 점수가 높은 순서대로 저장 
				for (int i = 0; i < 3; i++) {
					for(int k=i;k<3;k++) {
						int temp=0;
						String tempId=" ";
						if(scores[k]>scores[i]) {
							temp=scores[i];
							scores[i]=scores[k];
							scores[k]=temp;
							tempId=ids[i];
							ids[i]=ids[k];
							ids[k]=tempId;
					}
						
					}
					System.out.println(green+(i+1)+"등 "+"아이디: " + ids[i] + ", 최종 점수: " + scores[i]+exit);
				}
			}
		}
		
		in.close();

	}
	

}
