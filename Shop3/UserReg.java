package Shop3;

import java.util.ArrayList;

public class UserReg {
	//멤버변수
	String id=null;
	String name=null;
	String pwd=null;
	int money = 0;
	//유저가 구매한 물품을 저장할 arrayList
	ArrayList<Goods> goods=new ArrayList<>();
	
	UserReg(){
		
	}
	//구매목록 출력
	public void bprt() {
		System.out.println("아이디: "+id);
		for(int i=0;i<goods.size();i++) {
			
		}
		for(int i=0;i<goods.size();i++) {
			System.out.println("상품명: "+goods.get(i).goodsName);
			System.out.println("상품수량: "+goods.get(i).goodsNum);
			System.out.println("구매시간: "+goods.get(i).time);
		
		}
	}
	//아이디 설정
	public void setId(String id) {
		this.id=id;
	}
	//이름 설정		
	public void setName(String name) {
		this.name=name;
	}
	//비밀번호 설정
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}
	//아이디 리턴
	public String getId() {
		return id;
	}
	//비밀번호 리턴
	public String getPwd() {
		return pwd;
	}
	//상품구매
	public void buyGoods(String goodsName,int goodsNum) {
		Goods item=new Goods();
		item.setName(goodsName);
		item.setNum(goodsNum);
		item.setTime();
		goods.add(item);
		
	}
	// 잔액
	public void setMoney(int pay,int num) {
		money-=pay*num;
	}
}
