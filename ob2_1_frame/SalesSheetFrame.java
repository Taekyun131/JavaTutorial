package ob2_1_frame;

import java.util.ArrayList;

import ob2_1_item.ItemDTO;

public class SalesSheetFrame extends OrderSheetFrame {
	public SalesSheetFrame() {
		title_oMoney.setText("총 판매금액");
		oMoney.setText(idao.salesMoney()+"원");
	}
	@Override
	protected void showTable() {
		ArrayList<ItemDTO>ilist=idao.chkSales();
		for(ItemDTO temp:ilist) {
			addTable(temp);
		}
	}
}
