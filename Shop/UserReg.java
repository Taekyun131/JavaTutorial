package Shop;

import java.util.ArrayList;

public class UserReg {
	String id=null;
	String name=null;
	String pwd=null;
	
	ArrayList<Goods> goods=new ArrayList<>();
//	String goodsName=null;
//	int goodsQtt=0;
	
	UserReg(){
		
	}
	public void bprt() {
		System.out.println("아이디: "+id);
		for(int i=0;i<goods.size();i++) {
			
		}
		for(int i=0;i<goods.size();i++) {
			System.out.println("상품명: "+goods.get(i).goodsName);
			System.out.println("상품수량: "+goods.get(i).goodsNum);
		}
//		System.out.println("구매품목: "+goodsName);
//		System.out.println("구매수량: "+goodsQtt);
	}
	public void setId(String id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public void buyGoods(String goodsName,int goodsNum) {
		if(goods.size()==0) {
			Goods item=new Goods();
			item.setName(goodsName);
			item.setNum(goodsNum);
			goods.add(item);
		}else {
			for(int i=0;i<goods.size();i++) {
				if(goods.get(i).getName().equals(goodsName)) {
					goods.get(i).addNum(goodsNum);
					break;
				}
			}
			Goods item=new Goods();
			item.setName(goodsName);
			item.setNum(goodsNum);
			goods.add(item);
		}
	}
}
