package ob2_frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoginManagerFrame extends JFrame 
								implements ActionListener{
	private JPanel panel_t=new JPanel();
	private JPanel panel_c=new JPanel();
	private JLabel title=new JLabel("<html><body text='orange'><h2>스테이크 하우스</h2>");
	private JButton btn_1=new JButton("뒤로가기");
	//테이블
	//https://sourceforge.net/projects/jdatepicker/files/Releases/1.3.x/jdatepicker-1.3.4.jar/download
	//https://stackoverflow.com/questions/26794698/how-do-i-implement-jdatepicker참조
	String header[]= {"Item","Star","Cont","Visitdate"};
	DefaultTableModel tmodel=new DefaultTableModel(header,0);
	JTable table=new JTable(tmodel);
	JScrollPane scrolledTable=new JScrollPane(table);
	public LoginManagerFrame() {
		this.setBounds(150,150,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(panel_t);
		panel_t.add(btn_1);
		panel_t.add(title);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
