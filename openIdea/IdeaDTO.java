package openIdea;

public class IdeaDTO {
	private String title=null;
	private String content=null;
	private String writer=null;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "IdeaDTO [title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
}
