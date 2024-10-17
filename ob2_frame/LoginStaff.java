package ob2_frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginStaff extends JFrame
							implements ActionListener{

	private JPanel panel_t=new JPanel();
	private JLabel title=new JLabel("<html><body text='orange'><h2>스테이크 하우스입니다.</h2>");
	private JLabel title_wt=new JLabel("금일 근무시간 입력");
	private JLabel title_name=new JLabel();
	private JLabel title_pwd=new JLabel();
	private JTextField insert_wt=new JTextField();
	private JTextField insert_name=new JTextField();
	private JTextField insert_pwd=new JTextField();
	private JLabel title_mod=new JLabel("정보수정");
	private JLabel title_my=new JLabel("내 정보");
	private List infolist=new List(4,false);
	private JPanel panel_b=new JPanel();
	LoginStaff(){
		this.setBounds(150,150,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		panel_t.add(title);
		this.add(panel_t,"North");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
