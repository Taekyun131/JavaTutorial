package ob2_1_frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ob2_1_item.ItemDTO;
import ob2_1_item_dao.ItemDAO;

public class OrderSheetFrame extends JFrame {
	ItemDAO idao=ItemDAO.getInstance();
	protected JPanel panel_t=new JPanel();
	protected JPanel panel_c=new JPanel();
	protected JPanel panel_c1=new JPanel();
	protected JPanel panel_c2=new JPanel();
	protected JLabel title_oMoney=new JLabel("총 발주금액: ");
	protected JTextField oMoney=new JTextField();
	protected JLabel title=new JLabel("<html><body text='orange'><h2>스테이크 하우스</h2>");
	protected String header[]= {"Mname","Item","Price","Qty","Intime"};
	protected DefaultTableModel model=new DefaultTableModel(header,0);
	protected JTable table=new JTable(model);
	protected JScrollPane scrolledTable=new JScrollPane(table);
	OrderSheetFrame(){
		this.setBounds(150,150,600,500);
		this.setVisible(true);
		this.setResizable(false);
		this.add(panel_t,"North");
		panel_t.add(title);
		this.add(panel_c,"Center");
		panel_c.setLayout(new GridLayout(2,0));
		panel_c.add(panel_c1);
		panel_c1.setLayout(new BorderLayout());
		panel_c1.add(scrolledTable,"Center");
		panel_c.add(panel_c2);
		panel_c2.add(title_oMoney);
		panel_c2.add(oMoney);
		oMoney.setText(idao.orderMoney()+"원");
		oMoney.setEditable(false);
		showTable();
		
	}
	//JTable에 DB연결하여 Item들 추가
	protected void showTable() {
		ArrayList<ItemDTO>ilist=idao.chkOrder();
		for(ItemDTO temp:ilist) {
			addTable(temp);
		}
	}
	//JTable 한 행 추가
	protected void addTable(ItemDTO idto) {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		String []item=new String[5];
		item[0]=idto.getMname();
		item[1]=idto.getName();
		item[2]="가격: "+idto.getPrice();
		item[3]="수량: "+idto.getQuantity();
		item[4]=idto.getIntime();
		model.addRow(item);		
	}
	
}
