package Shop;

public class Goods {
	String goodsName = null;
	int goodsNum = 0;
	
	public void prt() {
		System.out.println(goodsName+"/"+goodsNum+"개");
	}
	public String getName() {
		return goodsName;
	}
	public int getNum() {
		return goodsNum;
	}
	public void setName(String goodsName) {
		this.goodsName=goodsName;
	}
	public void setNum(int goodsNum) {
		this.goodsNum=goodsNum;
	}
	public void addNum(int goodsNum) {
		this.goodsNum+=goodsNum;
	}
}
