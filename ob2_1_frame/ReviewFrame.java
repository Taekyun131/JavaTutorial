package ob2_1_frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import ob2_1_review_dao.ReviewDAO;
import ob2_1_review_dto.ReviewDTO;

public class ReviewFrame extends JFrame 
							implements ActionListener{
	private JPanel panel_t=new JPanel();
	private JPanel panel_st=new JPanel();
	private JLabel r_in_star=new JLabel("  별점(1, 2, 3, 4, 5): ");
	private JTextField r_star=new JTextField();
	private JLabel title=new JLabel("<html><body text='orange'><h2>스테이크 하우스</h2>");
	private JLabel r_in_title=new JLabel("  리뷰작성");
	private JLabel r_chk_title=new JLabel("  리뷰");
	private JLabel r_in_name=new JLabel("  이름: ");
	private JLabel r_in_vdate=new JLabel("  방문날짜: ");
	private JPanel panel_c=new JPanel();
	private JPanel panel_rIn=new JPanel();
	private JTextField r_name=new JTextField();
	private JTextField r_con=new JTextField("  후기를 작성해주세요");
	private JPanel panel_rIn_grid1=new JPanel();
	private JPanel panel_rIn_grid2=new JPanel();
	private JPanel panel_rIn_grid3=new JPanel();
	private JPanel panel_rchk=new JPanel();
	private JButton btn_1=new JButton("작성완료");
	private JButton btn_back=new JButton("뒤로가기");
	//날짜선택
	//https://stackoverflow.com/questions/26794698/how-do-i-implement-jdatepicker참조
	UtilDateModel model=new UtilDateModel();
	Properties p= new Properties();
	JDatePanelImpl datePanel=new JDatePanelImpl(model,p);
	JDatePickerImpl datePicker=new JDatePickerImpl(datePanel,new DateLabelFormater());
	//테이블
	//https://reakwon.tistory.com/167참조
	String header[]= {"Name","Star","Cont","Visitdate"};
	DefaultTableModel tmodel=new DefaultTableModel(header,0);
	JTable table=new JTable(tmodel);
	JScrollPane scrolledTable=new JScrollPane(table);
	ReviewDAO rdao=ReviewDAO.getInstance();
	
	ReviewFrame(){
		//프레임 기본설정
		this.setBounds(150,150,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		panel_t.add(btn_back);
		panel_t.add(title);
		
		this.add(panel_t,"North");
		panel_c.setLayout(new GridLayout(2,0));
		this.add(panel_c);
	
		
		//리뷰입력 패널
		panel_c.add(panel_rIn);
		panel_rIn.setLayout(new GridLayout(5,0));
		panel_rIn.add(r_in_title);
		panel_rIn.add(panel_st);
		panel_st.setLayout(new GridLayout(0,4));
		panel_st.add(r_in_star);
		panel_st.add(r_star);
		panel_rIn.add(panel_rIn_grid1);
		panel_rIn.add(r_con);
		panel_rIn.add(btn_1);
		panel_rIn_grid1.setLayout(new GridLayout(0,2));
		panel_rIn_grid1.add(panel_rIn_grid2);
		panel_rIn_grid2.setLayout(new GridLayout(0,2));
		panel_rIn_grid2.add(r_in_name);
		panel_rIn_grid2.add(r_name);
		panel_rIn_grid1.add(panel_rIn_grid3);
		panel_rIn_grid3.setLayout(new GridLayout(0,2));
		panel_rIn_grid3.add(r_in_vdate);
		panel_rIn_grid3.add(datePicker);
		datePicker.setVisible(true);
		
		//리뷰확인 패널
		panel_c.add(panel_rchk);
		panel_rchk.setLayout(new GridLayout(2,0));
		panel_rchk.add(r_chk_title);
		
		//리뷰테이블
		panel_rchk.add(scrolledTable,"Center");
		//버튼 리스너 등록
		btn_1.addActionListener(this);
		btn_back.addActionListener(this);
//		p.put("text.today", "Today");
//		p.put("text.month", "Month");
//		p.put("text.year", "Year");	
		DBTable();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_1) {	//리뷰 작성버튼 
			if(r_name.getText().equals("")||
					r_con.getText().equals("")) {
				JOptionPane.showMessageDialog(
						null,"내용을 입력하세요","리뷰작성",JOptionPane.WARNING_MESSAGE);
			}else {
				ReviewDTO rdto=new ReviewDTO();
				addTable(addReview(rdto));
				r_name.setText("");
				r_con.setText("");
				r_star.setText("");
			}
		}else if(e.getSource()==btn_back) {	//돌아가기버튼
			this.setVisible(false);
			new StartFrame();
		}
		
	}
	//리뷰달기
	private ReviewDTO addReview(ReviewDTO rdto) {
		String name=r_name.getText();
		String vdate=model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay();
		String con=r_con.getText();
		int star=Integer.parseInt(r_star.getText());
		rdto.setName(name);
		rdto.setContent(con);
		rdto.setStar(star);
		rdto.setVdate(vdate);
		rdao.review(rdto);
		return rdto;
	}
	//Jtable에 리뷰 추가
	public void addTable(ReviewDTO rdto) {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		String review[]=new String[4];
		review[0]=rdto.getName();
		review[1]="별점: "+rdto.getStar();
		review[2]=rdto.getContent();
		review[3]=rdto.getVdate();
		model.addRow(review);
		
	}
	//모든 리뷰 Jtable에 추가
	private void DBTable() {
		ArrayList<ReviewDTO>rlist=rdao.showReview();
		for(ReviewDTO temp:rlist) {
			addTable(temp);
		}
	}

}
