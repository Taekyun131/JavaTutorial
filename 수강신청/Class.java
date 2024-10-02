package 수강신청;

public class Class {
	private String title=null;
	private String room=null;
	private String prof=null;
	
	//getter&setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	//과목 출력
	public void prt() {
		System.out.println("과목: "+title);
		System.out.println("강의실: "+room);
		System.out.println("담당교수: "+prof);
		System.out.println();
	}
	
}
