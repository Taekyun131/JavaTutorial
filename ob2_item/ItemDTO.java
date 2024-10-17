package ob2_item;

public class ItemDTO {
	//식재 멤버변수
	private int no=0;
	private String name=null;
	private int price=0;
	private int quantity=0;
	
	//getter&setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	

	
	
	
	
	
}
