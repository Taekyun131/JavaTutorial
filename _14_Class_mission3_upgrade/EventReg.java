package _14_Class_mission3_upgrade;

public class EventReg {
	String title=null;
	String content=null;
	
	public void prt() {
		System.out.println("제목: "+title);
		System.out.println("내용: "+content);
		System.out.println();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String eTitle) {
		title=eTitle;
	}
	public void setContent(String eContent) {
		content=eContent;
	}
}
