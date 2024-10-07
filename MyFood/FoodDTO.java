package MyFood;

public class FoodDTO {
	private String name=null;
	private String intime=null;
	private int likeLevel=0; 

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLikeLevel() {
		return likeLevel;
	}

	public void setLikeLevel(int likeLevel) {
		this.likeLevel = likeLevel;
	}
	
}
