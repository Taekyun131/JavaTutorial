package javaWorld;

import java.util.ArrayList;
import java.util.Scanner;

public class EngMg {
	EngReg eReg=null;
	ArrayList<EngReg>wList=new ArrayList<>();
	Scanner in=new Scanner(System.in);
	EngMg(){
//		menu();
	}
	public void menu(){
		while(true) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 영단어 등록");
			System.out.println("2. 영단어 뜻");
			System.out.println("3. 영단어 전체 조회");
			System.out.println("4. 영단어 수정");
			System.out.println("5. 영단어 삭제");
			System.out.println("6. 단어게임");
			System.out.println("7. 프로그램 종료");
			int selNum=in.nextInt();
			in.nextLine();
			if(selNum==1) {
				addWord();
			}else if(selNum==2) {
				meanWord();
			}else if(selNum==3) {
				allWord();
			}else if(selNum==4) {
				modWord();
			}else if(selNum==5) {
				delWord();
			}else if(selNum==6) {
				WordGame wg=new WordGame();
				wg.start();
			}else if(selNum==7) {
				break;
			}
		}
	}
	public void addWord(){
		eReg=new EngReg();
		System.out.println("등록할 영단어를 입력하세요");
		String wordEng=in.nextLine();
		if(rpt(wordEng)) {
			eReg.setEng(wordEng);
			System.out.println("영단어의 뜻을 입력하세요");
			String wordKor=in.nextLine();
			eReg.setKor(wordKor);
			wList.add(eReg);
			
		}else {
			System.out.println("중복된 영단어가 있습니다.");
		}
		
	}
	public boolean rpt(String wordEng) {
		for(int i=0;i<wList.size();i++) {
			if(wList.get(i).getEng().equals(wordEng)) {
				return false;
			}
		}
		return true;
	}
	public void meanWord() {
		System.out.println("뜻을 알고싶은 영단어를 입력하세요");
		String wordEng=in.nextLine();
		for(int i=0;i<wList.size();i++) {
			if(wList.get(i).getEng().equals(wordEng)){
				System.out.println(wList.get(i).getKor());
				break;
			}
		}
		System.out.println("등록된 영단어가 없습니다.");
	}
	public void allWord() {
		for(int i=0;i<wList.size();i++) {
			wList.get(i).prt();
		}
	}
	public void modWord() {
		System.out.println("수정할 영단어를 입력하세요");
		String wordEng=in.nextLine();
		for(int i=0;i<wList.size();i++) {
			if(wList.get(i).getEng().equals(wordEng)) {
				System.out.println("수정할 뜻을 입력하세요");
				String wordKor=in.nextLine();
				wList.get(i).setKor(wordKor);
				break;
			}
		}
		System.out.println("수정할 영단어가 등록되어있지 않습니다.");
		
	}
	public void delWord() {
		System.out.println("삭제할 영단어를 입력하세요");
		String wordEng=in.nextLine();
		for(int i=0;i<wList.size();i++) {
			if(wList.get(i).getEng().equals(wordEng)) {
				wList.remove(i);
				break;
			}
		}
		System.out.println("삭제할 영단어가 없습니다.");
	}
	
	
}
