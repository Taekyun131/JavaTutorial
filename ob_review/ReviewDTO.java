package ob_review;

public class ReviewDTO {
	private int no=0;
	private String name=null;
	private String content=null;
	private int star=0;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	@Override
	public String toString() {
		return "[no=" + no + ", name=" + name + ", content=" + content + ", star=" + star + "]";
	}
	
}
