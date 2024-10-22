package ob2_1_frame;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ob2_1_staff.Staff;
import ob2_1_staff_dao.StaffDAO;

public class LoginStaffFrame extends JFrame
							implements ActionListener{
	private Staff login=null;
	private StaffDAO sdao=StaffDAO.getInstance();
	String id=null;
	String pwd=null;
	String lname=null;
	String wtime=null;
			
	private JPanel panel_t=new JPanel();
	private JPanel panel_c=new JPanel();
	private JPanel panel_c1=new JPanel();
	private JPanel panel_c2=new JPanel();
	private JPanel panel_c3=new JPanel();
	private JLabel title=new JLabel("<html><body text='orange'><h2>스테이크 하우스</h2>");
	private JLabel title_wt=new JLabel("금일 근무시간 입력");
	private JLabel title_name=new JLabel("이름 수정: ");
	private JLabel title_pwd=new JLabel("비밀번호 수정: ");
	private JTextField insert_wt=new JTextField();
	private JTextField insert_name=new JTextField();
	private JTextField insert_pwd=new JTextField();
	private JLabel title_mod=new JLabel("정보수정");
	private JLabel title_my=new JLabel("내 정보");
	private List infolist=new List(6,false);
	private JPanel panel_b1=new JPanel();
	private JPanel panel_b2=new JPanel();
	private JPanel panel_b3=new JPanel();
	private JButton btn_1=new JButton("입력");
	private JButton btn_2=new JButton("수정");
	private JButton btn_3=new JButton("뒤로가기");
	LoginStaffFrame(Staff login){
		this.login=login;
		this.setBounds(150,150,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		panel_t.add(btn_3,"West");
		panel_t.add(title);
		this.add(panel_t,"North");
		
		this.add(panel_c);
		//중앙패널
		panel_c.setLayout(new GridLayout(4,0));
		panel_c.add(panel_c1);
		panel_c.add(panel_c2);
		panel_c.add(panel_c3);
		
		panel_c1.setLayout(new GridLayout(4,0));
		panel_c1.add(panel_b1);
		panel_b1.setLayout(new GridLayout(0,2));
		panel_b1.add(title_wt,"west");
		
		//근무시간 입력 패널
		panel_c2.setLayout(new GridLayout(4,0));
		panel_c2.add(title_mod);
		panel_c2.add(panel_b2);
		panel_c1.add(btn_1);
		panel_b1.add(insert_wt);
		
		//정보수정란 패널
		panel_b2.setLayout(new GridLayout(0,2));
		panel_c2.add(panel_b3);
		panel_b3.setLayout(new GridLayout(0,2));
		panel_b2.add(title_name);
		panel_b2.add(insert_name);
		panel_b3.add(title_pwd);
		panel_b3.add(insert_pwd);
		panel_c2.add(btn_2);
		insert_name.setText(login.getName());
		insert_pwd.setText(login.getPwd());
		
		//내정보 패널
		panel_c3.setLayout(new GridLayout(2,0));
		panel_c3.add(title_my);
		panel_c.add(infolist);
		id="ID: "+login.getId();
		pwd="비밀번호: "+login.getPwd();
		lname="이름: "+login.getName();
		wtime="총 근무시간: "+login.getWorkTime();
		infolist.add(id);
		infolist.add(pwd);
		infolist.add(lname);
		infolist.add(wtime);
		
		//버튼 리스너 등록
		btn_1.addActionListener(this);
		btn_2.addActionListener(this);
		btn_3.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//근무시간 입력
		if(e.getSource()==btn_1) {
			if(insert_wt.getText().equals("")) {
				JOptionPane.showMessageDialog(
						null,"근무시간을 입력하세요","에러",JOptionPane.PLAIN_MESSAGE);
			}else {
				insertWtime();
				JOptionPane.showMessageDialog(
						null,"입력이 완료되었습니다","성공",JOptionPane.PLAIN_MESSAGE);
			}
		}//정보수정
		else if(e.getSource()==btn_2){
			JOptionPane.showMessageDialog(
					null,"변경이 완료되었습니다","성공",JOptionPane.PLAIN_MESSAGE);
			modIfo();
		}else if(e.getSource()==btn_3) {
			this.setVisible(false);
		}
		
	}
	//근무시간 입력
	private void insertWtime() {
		int wtime1=Integer.parseInt(insert_wt.getText());
		sdao.addWtime(login, wtime1);
		login=sdao.returnStaff(login);
		String wtime="총 근무시간: "+login.getWorkTime();
		infolist.remove(3);
		infolist.add(wtime,3);
		insert_wt.setText("");
	}
	//내 정보 수정
	private void modIfo() {
		String name=insert_name.getText();
		String pwd=insert_pwd.getText();
		sdao.modInfo(login.getId(),pwd,name);
		login=sdao.returnStaff(login);
		infolist.removeAll();
		id="ID: "+login.getId();
		pwd="비밀번호: "+login.getPwd();
		name="이름: "+login.getName();
		wtime="총 근무시간: "+login.getWorkTime();
		infolist.add(id);
		infolist.add(pwd);
		infolist.add(name);
		infolist.add(wtime);
	}
}
