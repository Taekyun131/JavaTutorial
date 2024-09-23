package _14_Class_mission3;

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
	public String getContent() {
		return content;
	}
	public void setTitle(String etitle) {
		title=etitle;
	}
	public void setContent(String econtent) {
		content=econtent;
	}
}

	
