package javaWorld_answer;

public class WordOne {
	String ename=null;
    String kname=null;
     public void prt() {
    	 System.out.println(ename);
    	 System.out.println(kname);
    	 
     }    // 단어와 한글 뜻 출력
     public void setEname(String ename) {
    	 this.ename=ename;
     }     // 영어 단어 저장
     public void setKname(String kname) {;    // 한글 단어 저장
     	 this.kname=kname;
     }
     public String getEname() {    // 영어 단어 조회
    	 return ename;
     }
     public String getKname() {
    	 return kname;
     }    // 한글 단어 조회
}
