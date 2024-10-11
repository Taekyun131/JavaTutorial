package wordlove;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	private JPanel title_p=new JPanel();
	private JLabel t=new JLabel("단어장 프로그램");
	private JPanel center_p=new JPanel();
	private JPanel center_1=new JPanel();
	private JPanel center_2=new JPanel();
	private JPanel center_3=new JPanel();
	public MainFrame(){
		this.setBounds(100,100,500,180);
		title_p.add(t);
		center_p.setBackground(Color.yellow);
		this.add(title_p,"North");
		this.add(center_p,"Center");
		center_1.setBackground(Color.red);
		center_2.setBackground(Color.cyan);
		center_3.setBackground(Color.green);
		//3개의 패널을 center_p에 추가
		center_p.setLayout(new GridLayout());
		center_p.add(center_1);
		center_p.add(center_2);
		center_p.add(center_3);
		
		//center_1 작업
		JLabel c1=new JLabel("단어입력");
		JButton c1btn=new JButton("저장");
		JPanel c1c=new JPanel();
		c1c.setBackground(Color.gray);
		c1c.setLayout(new GridLayout(2,2));
		JLabel c2=new JLabel("영어");
		JLabel c3=new JLabel("한글");
		JTextField j1=new JTextField();
		JTextField j2=new JTextField();
		c1c.add(c2);
		c1c.add(j1);
		c1c.add(c3);
		c1c.add(j2);
		center_1.setLayout(new BorderLayout());
		center_1.add(c1,"North");
		center_1.add(c1btn,"South");
		center_1.add(c1c,"Center");
		
		//center_2 작업
		JPanel c22=new JPanel();
		c22.setLayout(new BorderLayout());
		JLabel c22l=new JLabel("단어리스트");
		List c22list=new List();
		JButton c22btn=new JButton("선택단어삭제");
		c22.add(c22l,"North");
		c22.add(c22list,"Center");
		c22.add(c22btn,"South");
		center_2.setLayout(new BorderLayout());
		center_2.add(c22,"Center");
		
		
		//center_3 작업
		JLabel c5=new JLabel("단어수정");
		JButton c5btn=new JButton("수정");
		JPanel c5c=new JPanel();
		c5c.setBackground(Color.gray);
		c5c.setLayout(new GridLayout(2,2));
		JLabel c6=new JLabel("영어");
		JLabel c7=new JLabel("한글");
		JTextField j5=new JTextField();
		JTextField j6=new JTextField();
		c5c.add(c6);
		c5c.add(j5);
		c5c.add(c7);
		c5c.add(j6);
		center_3.setLayout(new BorderLayout());
		center_3.add(c5,"North");
		center_3.add(c5btn,"South");
		center_3.add(c5c,"Center");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
