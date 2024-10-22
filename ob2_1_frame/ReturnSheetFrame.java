package ob2_1_frame;

import java.util.ArrayList;

import ob2_1_item.ItemDTO;

public class ReturnSheetFrame extends OrderSheetFrame{
	public ReturnSheetFrame() {
		title_oMoney.setText("총 반품금액");
		oMoney.setText(idao.returnMoney()+"원");
	}
	@Override
	protected void showTable() {
		ArrayList<ItemDTO>ilist=idao.chkReturn();
		for(ItemDTO temp:ilist) {
			addTable(temp);
		}
	}
	
	
	
}
