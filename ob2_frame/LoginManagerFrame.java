package ob2_frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ob2_item.ItemDTO;
import ob2_item_dao.ItemDAO;
import ob2_staff.Manager;

public class LoginManagerFrame extends JFrame 
								implements ActionListener{
	private JPanel panel_t=new JPanel();
	private JPanel panel_c=new JPanel();
	private JLabel title=new JLabel("<html><body text='orange'><h2>스테이크 하우스</h2>");
	private JLabel title_qty=new JLabel("수량: ");
	private JTextField qtyIn=new JTextField();
	private JButton btn_back=new JButton("뒤로가기");
	private JButton btn_order=new JButton("발주하기");
	private JButton btn_return=new JButton("반품하기");
	private JButton btn_sale=new JButton("판매하기");
	private JPanel panel_b=new JPanel();
	private JPanel panel_b1=new JPanel();
	private JPanel panel_b2=new JPanel();
	private JPanel panel_b3=new JPanel();
	private JButton btn_sheet_o=new JButton("발주시트보기");
	private JButton btn_sheet_r=new JButton("반품시트보기");
	private JButton btn_sheet_s=new JButton("판매시트보기");
	//테이블
	//https://reakwon.tistory.com/167 참조
	String header[]= {"No","Item","Price","Qty"};
	DefaultTableModel tmodel=new DefaultTableModel(header,0);
	JTable table=new JTable(tmodel);
	JScrollPane scrolledTable=new JScrollPane(table);
	ItemDAO idao=ItemDAO.getInstance();
	Manager m=null;
	
	public LoginManagerFrame(Manager login) {
		this.m=login;
		this.setBounds(150,150,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(panel_t,"North");
		this.add(scrolledTable,"Center");
//		panel_t.setLayout(new BorderLayout());
		panel_t.add(btn_back,"West");
		panel_t.add(title,"Center");
		
		//센터패널
//		this.add(panel_c,"Center");
		
		//버튼 패널
		this.add(panel_b,"South");
		panel_b.setLayout(new GridLayout(4,0));
		panel_b.add(panel_b1);
		panel_b1.setLayout(new GridLayout(0,4));
//		panel_b1.add(title_no);
//		panel_b1.add(noIn);
		panel_b1.add(title_qty);
		panel_b1.add(qtyIn);
		panel_b.add(panel_b2);
		panel_b2.add(btn_order);
		panel_b2.add(btn_return);
		panel_b2.add(btn_sale);
		panel_b.add(panel_b3);
		panel_b3.add(btn_sheet_o);
		panel_b3.add(btn_sheet_r);
		panel_b3.add(btn_sheet_s);
		//버튼 리스너 등록
		btn_back.addActionListener(this);
		btn_order.addActionListener(this);
		btn_return.addActionListener(this);
		btn_sale.addActionListener(this);
		btn_sheet_o.addActionListener(this);
		btn_sheet_r.addActionListener(this);
		btn_sheet_s.addActionListener(this);
		
		//테이블 데이터입력
		showTable();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String input=qtyIn.getText();
		if(e.getSource()==btn_back) {//뒤로가기버튼
			this.setVisible(false);
		}else if(e.getSource()==btn_sheet_o){
			new OrderSheetFrame();
		}else if(e.getSource()==btn_sheet_r){
			new ReturnSheetFrame();
		}else if(e.getSource()==btn_sheet_s){
			new SalesSheetFrame();
		}
		else {
			if(input.equals("")){//수량 미입력시
				JOptionPane.showMessageDialog(
						null,"수량을 입력하세요","에러",JOptionPane.ERROR_MESSAGE);
			}else {
				int no=table.getSelectedRow()+1;
				int qty=Integer.parseInt(input);
				if(e.getSource()==btn_order) {//발주버튼
					orderItem(no,qty);
					JOptionPane.showMessageDialog(
							null,"발주완료","성공",JOptionPane.PLAIN_MESSAGE);
				}else if(e.getSource()==btn_return) {//반품버튼
					returnItem(no, qty);
					JOptionPane.showMessageDialog(
							null,"반품완료","성공",JOptionPane.PLAIN_MESSAGE);
				}else if(e.getSource()==btn_sale) {//판매버튼
					saleItem(no, qty);
					JOptionPane.showMessageDialog(
							null,"판매완료","성공",JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
	}
	//JTable에 DB연결하여 Item들 추가
	private void showTable() {
		ArrayList<ItemDTO>ilist=idao.allItem();
		for(ItemDTO temp:ilist) {
			addTable(temp);
		}
	}
	//JTable 한 행 추가
	private void addTable(ItemDTO idto) {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		String []item=new String[4];
		item[0]="No: "+idto.getNo();
		item[1]=idto.getName();
		item[2]="가격: "+idto.getPrice();
		item[3]="수량: "+idto.getQuantity();
		model.addRow(item);		
	}
	//발주하기
	private void orderItem(int no,int qty) {
		idao.orderItem(no, qty);
		idao.addOrder(m.getName(), no, qty);
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
	    dm.getDataVector().removeAllElements();
	    showTable();
		qtyIn.setText("");
	}
	//반품하기
	private void returnItem(int no,int qty) {
		idao.returnItem(no, qty);
		idao.addReturn(m.getName(), no, qty);
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
	    dm.getDataVector().removeAllElements();
	    showTable();
		qtyIn.setText("");
	}
	//판매하기
	private void saleItem(int no,int qty) {
		idao.salesItem(no, qty);
		idao.addRevenue(m.getName(), no, qty);
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
	    dm.getDataVector().removeAllElements();
	    showTable();
		qtyIn.setText("");
	}
}
