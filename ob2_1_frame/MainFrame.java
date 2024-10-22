package ob2_1_frame;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ob2_1_staff.Manager;
import ob2_1_staff.Owner;
import ob2_1_staff.Staff;
import ob2_1_staff_dao.StaffDAO;

public class MainFrame extends JFrame
						implements ActionListener{
	
	StaffDAO sdao=StaffDAO.getInstance();
	private JPanel panel_t=new JPanel();
	private JPanel panel_i1=new JPanel();
	private JPanel panel_i2=new JPanel();
	private JPanel panel_i3=new JPanel();
	private JPanel panel_b=new JPanel();
	private JPanel panel_c=new JPanel();
	CheckboxGroup cbx_g=new CheckboxGroup();
	CheckboxGroup cbx_g2=new CheckboxGroup();
	Checkbox cbx1=new Checkbox("직원",cbx_g,true);
	Checkbox cbx2=new Checkbox("매니저",cbx_g,false);
	Checkbox cbx3=new Checkbox("점주",cbx_g,false);
	JLabel titleId=new JLabel("ID: ");
	JLabel titlePwd=new JLabel("PW: ");
	JTextField insertId=new JTextField();
	JTextField insertPwd=new JTextField();
	JButton btn_1=new JButton("로그인");
	private JLabel title=new JLabel("<html><body text='orange'><h2>스테이크 하우스</h2>");
	public MainFrame() {
		//프레임 기본설정
		this.setBounds(150,150,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		panel_t.add(title);
		this.add(panel_t,"North");
		this.add(panel_b);
		panel_b.setLayout(new GridLayout(10,0));
		panel_b.add(panel_i1);
		panel_b.add(panel_i2);
		panel_b.add(panel_i3);
		panel_b.add(panel_c);
		panel_c.setLayout(new FlowLayout());
		panel_c.add(cbx1);
		panel_c.add(cbx2);
		panel_c.add(cbx3);
		
		panel_i1.setLayout(new GridLayout(0,2));
		panel_i1.add(titleId);
		panel_i1.add(insertId);
		panel_i2.setLayout(new GridLayout(0,2));
		panel_i2.add(titlePwd);
		panel_i2.add(insertPwd);
		panel_i3.add(btn_1);
		
		
		btn_1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(cbx1.getState()
				&&e.getSource()==btn_1) {
			String id=insertId.getText();
			String pwd=insertPwd.getText();
			insertId.setText("");
			insertPwd.setText("");
			Staff login=sdao.loginchk(id, pwd);
			if(login!=null) {
				new LoginStaffFrame(login);
			}else {
				JOptionPane.showMessageDialog(
						null,"아이디와 비밀번호를 확인하세요","로그인 실패",JOptionPane.ERROR_MESSAGE);
			}
		}else if(cbx2.getState()
					&&e.getSource()==btn_1) {
			String id=insertId.getText();
			String pwd=insertPwd.getText();
			insertId.setText("");
			insertPwd.setText("");
			Manager login=sdao.loginMchk(id, pwd);
			if(login!=null) {
				new LoginManagerFrame(login);
			}else {
				JOptionPane.showMessageDialog(
						null,"아이디와 비밀번호를 확인하세요","로그인 실패",JOptionPane.ERROR_MESSAGE);
			}
			
		}else if(cbx3.getState()
					&&e.getSource()==btn_1) {
			String id=insertId.getText();
			String pwd=insertPwd.getText();
			insertId.setText("");
			insertPwd.setText("");
			Owner login=sdao.loginOchk(id, pwd);
			if(login!=null) {
				new LoginOwnerFrame(login);
			}else {
				JOptionPane.showMessageDialog(
						null,"아이디와 비밀번호를 확인하세요","로그인 실패",JOptionPane.ERROR_MESSAGE);
			}
			
		}
				
	}
}
