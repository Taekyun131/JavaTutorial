package javaWorld;

public class EngReg {
	String Eng=null;
	String Kor=null;
	EngReg(){
		
	}
	public void prt() {
		System.out.println("영단어: "+Eng);
		System.out.println("뜻: "+Kor);
		System.out.println();
	}
	public String getEng() {
		return Eng;
	}
	public String getKor() {
		return Kor;
	}
	public void setEng(String wordEng) {
		Eng=wordEng;
	}
	public void setKor(String wordKor) {
		Kor=wordKor;
	}
}
