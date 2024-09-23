package _14_Class_mission3;

public class ClientInfo {
	String id=null;
	String name=null;
	public void prt() {
		System.out.println("아이디: "+id);
		System.out.println("이름: "+name);
		System.out.println();
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void  setId(String cid) {
		id=cid;
	}
	public void setName(String cname) {
		name=cname;
	}
}
