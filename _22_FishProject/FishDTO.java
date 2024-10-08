package _22_FishProject;

public class FishDTO {
	private String id=null;
	private String pwd=null;
	private String indate=null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	
	//DTO정보 디버깅 메서드
	@Override
	public String toString() {
		return "FIshDTO [id=" + id + ", pwd=" + pwd + ", indate=" + indate + "]";
	}
	
	
	
}
