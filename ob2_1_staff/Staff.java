package ob2_1_staff;

public class Staff {
	//직원 멤버변수
	private String name=null;
	private String rank=null;
	private String id=null;
	private String pwd=null;
	private int workTime=0;
	
	//getter&setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
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
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	@Override
	public String toString() {
		return "Staff [name=" + name + ", rank=" + rank + ", id=" + id + "]";
	}
	
	
	
	
	
	
	
	
}
