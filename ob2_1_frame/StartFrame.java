package ob2_1_frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartFrame extends JFrame 
						implements ActionListener{
	JPanel panel_t=new JPanel();
	JPanel panel_c=new JPanel();
	JPanel panel_b=new JPanel();
	JPanel panel_b1=new JPanel();
	JLabel title=new JLabel("<html><body text='orange'><h1>스테이크 하우스</h1>");
	JLabel title1=new JLabel("<html><body text='black'><h2>메뉴를 선택하세요</h2>");
	JLabel titleId=new JLabel("ID: ");
	JLabel titlePwd=new JLabel("PW: ");
	JTextField insertId=new JTextField();
	JTextField insertPwd=new JTextField();
	JButton btn_1=new JButton("고객");
	JButton btn_2=new JButton("직원");
	
	
	StartFrame(){
		this.setBounds(150,150,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		//제목 추가
		panel_t.add(title);
		this.add(panel_t,"North");
		panel_t.setLayout(new FlowLayout(FlowLayout.CENTER));
		//소제목&버튼 추가
		this.add(panel_c);
		panel_c.setLayout(new GridLayout(2,0));
		panel_c.add(panel_b1);
		panel_b1.add(title1);
		panel_c.add(panel_b);
		panel_b.add(btn_1);
		panel_b.add(btn_2);
		//버튼 리스너 등록
		btn_1.addActionListener(this);
		btn_2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_1) {
			this.setVisible(false);
			new ReviewFrame();
		}else if(e.getSource()==btn_2) {
			this.setVisible(false);
			new MainFrame();
		}
	}
}
