package javaProject;

public class UserReg {
	String id=null;
	String name=null;
	String pwd=null;
	String goodsName=null;
	int goodsQtt=0;
	
	UserReg(){
		
	}
	public void bprt() {
		System.out.println(id);
		System.out.println(goodsName);
		System.out.println(goodsQtt);
	}
	public void setId(String id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
}
