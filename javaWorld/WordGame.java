package javaWorld;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
	EngMg eMg=new EngMg();
	ArrayList<EngReg> wrongWord=new ArrayList<>();
	Random r=new Random();
	Scanner in=new Scanner(System.in);
	WordGame(){
//		??????
	}
	public void start() {
		System.out.println("-----영단어 맞추기 게임-----");
		System.out.println("출력된 뜻을 가진 영단어를 입력하세요");
		System.out.println("시작하려면 아무키나 입력하세요");
		in.nextLine();
		System.out.println("영단어 개수: "+eMg.wList.size());
		if(eMg.wList.size()==0) {
			System.out.println("게임을 시작할 단어가 부족합니다.");
			System.out.println("게임을 종료합니다.");
		}else {
			for(int i=0;i<eMg.wList.size();i++) {
				int random=r.nextInt(eMg.wList.size());
				System.out.println(eMg.wList.get(random));
				String answer=in.nextLine();
				if(eMg.wList.get(random).getKor().equals(answer)) {
					System.out.println("정답");
				}else {
					System.out.println("오답");
					wrongWord.add(eMg.wList.get(random));
				}
			}
		}
		
	}
}
