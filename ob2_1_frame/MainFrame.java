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
	
	private StaffDAO sdao=StaffDAO.getInstance();
	private JPanel panel_t=new JPanel();
	private JPanel panel_i1=new JPanel();
	private JPanel panel_i2=new JPanel();
	private JPanel panel_i3=new JPanel();
	private JPanel panel_i4=new JPanel();
	private JPanel panel_i5=new JPanel();
	private JPanel panel_i6=new JPanel();
	private JPanel panel_b=new JPanel();
	private JPanel panel_c=new JPanel();
	private JPanel panel_r=new JPanel();
	private JLabel titleR=new JLabel("직급을 선택하세요");
	private CheckboxGroup cbx_g=new CheckboxGroup();
	private CheckboxGroup cbx_g2=new CheckboxGroup();
	private Checkbox cbx1=new Checkbox("직원",cbx_g,true);
	private Checkbox cbx2=new Checkbox("매니저",cbx_g,false);
	private Checkbox cbx3=new Checkbox("점주",cbx_g,false);
	private JLabel titleId=new JLabel("ID: ");
	private JLabel titlePwd=new JLabel("PW: ");
	private JTextField insertId=new JTextField();
	private JTextField insertPwd=new JTextField();
	private JButton btn_1=new JButton("로그인");
	private JLabel title=new JLabel("<html><body text='orange'><h1>스테이크 하우스</h1>");
	private JLabel titleL=new JLabel("<html><body text='black'><h2>로그인</h2>");
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
		panel_b.add(panel_i4);
		panel_b.add(panel_r);
		panel_r.setLayout(new FlowLayout());
		panel_r.add(titleR);
		panel_b.add(panel_c);
		panel_i4.add(titleL);
		panel_b.add(panel_i5);
		panel_b.add(panel_i1);
		panel_b.add(panel_i2);
		panel_b.add(panel_i3);
		panel_c.setLayout(new FlowLayout());
		panel_c.add(cbx1);
		panel_c.add(cbx2);
		panel_c.add(cbx3);
		
		panel_i1.setLayout(new GridLayout(0,4));
		panel_i1.add(panel_i5);
		panel_i1.add(titleId);
		panel_i1.add(insertId);
		panel_i2.setLayout(new GridLayout(0,4));
		panel_i2.add(panel_i6);
		panel_i2.add(titlePwd);
		panel_i2.add(insertPwd);
		panel_i3.add(btn_1);
		
		
		btn_1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(cbx1.getState()	
				&&e.getSource()==btn_1) {	//체크박스 직원&로그인 시
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
					&&e.getSource()==btn_1) {	//체크박스 매니저&로그인 시
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
					&&e.getSource()==btn_1) {	//체크박스 점주&로그인 시
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
