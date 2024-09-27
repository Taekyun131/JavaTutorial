package Shop4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Goods {
	String goodsName = null;
	int goodsNum = 0;
	int pay = 0;
	String time=null;
	
	//품목 수량 출력
	public void prt() {
		System.out.println("---------------");
		System.out.println(goodsName+"\t"+goodsNum+"개");
		System.out.println(pay+"원");
	}
	//상품명 리턴
	public String getName() {
		return goodsName;
	}
	//상품수량 리턴
	public int getNum() {
		return goodsNum;
	}
	//상품명 설정
	public void setName(String goodsName) {
		this.goodsName=goodsName;
	}
	//상품수량 설정
	public void setNum(int goodsNum) {
		this.goodsNum=goodsNum;
	}
	//상품수량 추가
	public void addNum(int goodsNum) {
		this.goodsNum+=goodsNum;
	}
	//구매시간설정
	public void setTime() {
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		this.time=now.format(formatter);
	}
}
