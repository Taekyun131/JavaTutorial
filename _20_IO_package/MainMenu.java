package _20_IO_package;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MainMenu {
	
	MainMenu(){
			menu();
	}
	private void menu() {
		try {
			while(true) {
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("메뉴를 선택하세요");
				System.out.println("1. 영단어 등록");
				System.out.println("2. 영단어 검색");
				System.out.println("3. 모든 영단어 보기");
				System.out.println("4. 프로그램 종료");
				int selNum=Integer.parseInt(br.readLine());
				if(selNum==1) {
					add();
				}else if(selNum==2) {
					search();
				}else if(selNum==3) {
					allWord();
				}else if(selNum==4) {
					break;
				}
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	private void add() {
		try {
			File file=new File("EngWord.txt");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("등록할 영단어를 입력하세요");
			String eword=br.readLine();
			System.out.println("영단어의 뜻을 입력하세요");
			String kword=br.readLine();
			FileWriter writer=new FileWriter(file,true);
			BufferedWriter bw=new BufferedWriter(writer);
			bw.write(eword+" ");
			bw.write(kword+"\n");
			bw.flush();
			bw.close();
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private void search() {
		try {
			System.out.println("검색할 영단어를 입력하세요");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String type=br.readLine();
			File file=new File("EngWord.txt");
			FileReader fr=new FileReader(file);
			br=new BufferedReader(fr);
			while(true) {
				String line=br.
				if(line.equals(type)) {
					System.out.println(line);
				}
			}
			br.close();
			
			
		}catch (Exception e) {
			e.getStackTrace();
		}
		
	}
	private void allWord() {
		try {
			File file=new File("EngWord.txt");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			while (true) {
				String line=br.readLine();
				if(line==null) {
					break;
				}
				System.out.println(line);
			}
			br.close();
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
