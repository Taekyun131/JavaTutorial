package wordlove;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WordFrame extends JFrame implements ActionListener {
	private WordDAO wdao=WordDAO.getInstance();
	private JLabel title=new JLabel("단어장 프로그램");
	private JLabel titleL=new JLabel("단어입력");
	private JLabel titleC=new JLabel("단어 리스트");
	private JLabel titleR=new JLabel("단어수정");
	private JLabel titleKor1=new JLabel("한글");
	private JLabel titleEng1=new JLabel("영어");
	private JLabel titleKor2=new JLabel("한글");
	private JLabel titleEng2=new JLabel("영어");
	private JTextField insertKor =new JTextField();
	private JTextField insertEng =new JTextField();
	private JTextField modKor=new JTextField();
	private JTextField modEng=new JTextField();
	private List wordList=new List(5,false);
	private JPanel panelTop=new JPanel();
	private JPanel panelMid=new JPanel();
	private JPanel panelLeft=new JPanel();
	private JPanel panelCen=new JPanel();
	private JPanel panelRight=new JPanel();
	private JPanel panelIn1=new JPanel();
	private JPanel panelIn1T=new JPanel();
	private JPanel panelIn2T=new JPanel();
	private JPanel panelIn2=new JPanel();
	private JButton save=new JButton("저장");
	private JButton mod=new JButton("수정");
	private JButton del=new JButton("선택단어 삭제");
	//프레임 설계
	public WordFrame() {
		this.setBounds(200,200,800,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//제목
		this.add(panelTop,"North");
		panelTop.add(title);
		panelTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//전체패널
		this.add(panelMid);
		panelMid.setLayout(new GridLayout(0,3));
		panelMid.add(panelLeft);
		panelMid.add(panelCen);
		panelMid.add(panelRight);
		//왼쪽패널
		panelLeft.setLayout(new GridLayout(3,0));
		panelLeft.add(titleL);
		
		panelLeft.add(panelIn1);
		panelIn1.add(panelIn1T);
		panelIn1T.setLayout(new GridLayout(2,0));
		
		panelIn1T.add(titleEng1);
		panelIn1T.add(insertEng);
		panelIn1T.add(titleKor1);
		panelIn1T.add(insertKor);
		panelIn1.setLayout(new GridLayout(2,0));
		
		panelLeft.add(save);
		
		//중간패널
		panelCen.setLayout(new GridLayout(3,0));
		panelCen.add(titleC);
		panelCen.add(wordList);
		panelCen.add(del);
		
		
		//오른쪽패널
		panelRight.setLayout(new GridLayout(3,0));
		panelRight.add(titleR);
		
		panelRight.add(panelIn2);
		panelIn2T.setLayout(new GridLayout(2,0));
		panelIn2T.add(titleEng2);
		panelIn2T.add(modEng);
		panelIn2T.add(titleKor2);
		panelIn2T.add(modKor);
		panelIn2.add(panelIn2T);
		panelIn2.setLayout(new GridLayout(2,0));
		
		panelRight.add(mod);
		
		//리스너 등록
		save.addActionListener(this);
		mod.addActionListener(this);
		del.addActionListener(this);
		
		
		loadDB();
	}
	
	
	
	
	//db연동
	private void loadDB() {
		ArrayList<WordDTO>wlist=wdao.selectAll();
		for(WordDTO t:wlist) {
			wordList.add(t.getEng()+":"+t.getKor());
		}
	}
	// 단어리스트 새로고침
	private void updateDB() {
		ArrayList<WordDTO>wlist=wdao.selectAll();
		wordList.removeAll();
		for(WordDTO t:wlist) {
			wordList.add(t.getEng()+":"+t.getKor());
		}
	}


	@Override	//버튼 
	public void actionPerformed(ActionEvent e) {
		//insert
		if(e.getSource()==save) {
			String inKor=insertKor.getText();
			String inEng=insertEng.getText();
			WordDTO wdto=new WordDTO();
			wdto.setEng(inEng);
			wdto.setKor(inKor);
			wdao.insert(wdto);
			insertKor.setText("");
			insertEng.setText("");
			updateDB();
		}
		//update
		else if(e.getSource()==mod) {
			String modkor=modKor.getText();
			String modeng=modEng.getText();
			wdao.update(modeng, modkor);
			updateDB();
		}
		//delete
		else if(e.getSource()==del) {
			ArrayList<WordDTO>wlist=wdao.selectAll();
			if(wordList.getSelectedItem()!=null) {
				wdao.delete(wlist.get(wordList.getSelectedIndex()).getEng());
				wordList.remove(wordList.getSelectedItem());
			}
		}
	}
	
}
