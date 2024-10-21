package ob2_frame;

import java.awt.Component;
import java.awt.FlowLayout;
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

import ob2_item_dao.ItemDAO;
import ob2_review_dao.ReviewDAO;
import ob2_review_dto.ReviewDTO;
import ob2_staff.Owner;
import ob2_staff.Staff;
import ob2_staff_dao.StaffDAO;

public class LoginOwnerFrame extends JFrame
								implements ActionListener{
	Owner o=null;
	private JPanel panel_t=new JPanel();
	private JPanel panel_t1=new JPanel();
	private JPanel panel_c=new JPanel();
	private JPanel panel_c1=new JPanel();
	private JPanel panel_c1R=new JPanel();
	private JPanel panel_c1R1=new JPanel();
	private JPanel panel_c1R2=new JPanel();
	private JPanel panel_c1R3=new JPanel();
	
	private JPanel panel_c2=new JPanel();
	private JPanel panel_c2R=new JPanel();
	private JPanel panel_c2R1=new JPanel();
	private JPanel panel_c2R2=new JPanel();
	private JLabel title=new JLabel("<html><body text='orange'><h2>스테이크 하우스</h2>");
	private JButton btn_back=new JButton("뒤로가기");
	private JLabel title_sales_0=new JLabel("");
	private JLabel title_sales=new JLabel("매출: ");
	private JLabel title_name=new JLabel("이름: ");
	private JLabel title_rank=new JLabel("직급: ");
	private JLabel title_id=new JLabel("아이디: ");
	private JLabel title_pwd=new JLabel("비밀번호: ");
	private JLabel title_star=new JLabel("평점: ");
	private JTextField inName=new JTextField();
	private JTextField inRank=new JTextField();
	private JTextField inId=new JTextField();
	private JTextField inPwd=new JTextField();
	private JTextField total_star=new JTextField();
	private JTextField sales=new JTextField("1000000000");
	private JButton btn_emp=new JButton("직원채용");
	private JButton btn_ret=new JButton("사직원 제출");
	private JButton btn_delRv=new JButton("리뷰삭제");
	//직원테이블
	String headerS[]= {"Name","ID","PW","Rank"};
	DefaultTableModel tmodelS=new DefaultTableModel(headerS,0);
	JTable tableS=new JTable(tmodelS);
	JScrollPane scrolledTableS=new JScrollPane(tableS);
	//리뷰테이블
	String headerR[]= {"No","Star","Cont"};
	DefaultTableModel tmodelR=new DefaultTableModel(headerR,0);
	JTable tableR=new JTable(tmodelR);
	JScrollPane scrolledTableR=new JScrollPane(tableR);
	StaffDAO sdao=StaffDAO.getInstance();
	ReviewDAO rdao=ReviewDAO.getInstance();
	ItemDAO idao=ItemDAO.getInstance();
	LoginOwnerFrame(Owner o){
		this.o=o;
		this.setBounds(150,150,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(panel_t,"North");
		panel_t.add(btn_back,"West");
		panel_t.add(title,"Center");
		
		
		panel_c.setLayout(new GridLayout(2,0));
		panel_c.add(panel_c1);
		panel_c.add(panel_c2);
		this.add(panel_c,"Center");
		//직원패널
		panel_c1.setLayout(new GridLayout(0,2));
		panel_c1.add(scrolledTableS);
		allStaff();
		//직원패널 입력&버튼
		panel_c1.add(panel_c1R);
		panel_c1R.setLayout(new GridLayout(6,0));
		panel_c1R.add(panel_c1R1);
		//아이디, 직급
		panel_c1R1.setLayout(new GridLayout(0,4));
		panel_c1R1.add(title_name);
		panel_c1R1.add(inName);
		panel_c1R1.add(title_rank);
		panel_c1R1.add(inRank);
		//아이디,비밀번호
		panel_c1R.add(panel_c1R2);
		panel_c1R2.setLayout(new GridLayout());
		panel_c1R2.add(title_id);
		panel_c1R2.add(inId);
		panel_c1R2.add(title_pwd);
		panel_c1R2.add(inPwd);
		//버튼
		panel_c1R.add(panel_c1R3);
		panel_c1R3.setLayout(new FlowLayout());
		panel_c1R3.add(btn_emp);
		panel_c1R3.add(btn_ret);
		
		
		
		//리뷰패널
		panel_c2.setLayout(new GridLayout(0,2));
		panel_c2.add(scrolledTableR);
		allReview();
		//평점&버튼
		panel_c2.add(panel_c2R);
		panel_c2R.setLayout(new GridLayout(6,0));
		panel_c2R.add(panel_c2R1);
		panel_c2R1.add(title_star);
		panel_c2R1.add(total_star);
		total_star.setEditable(false);
		total_star.setText(rdao.avgStar()+"점");
		
		panel_c2R.add(panel_c2R2);
		panel_c2R2.add(btn_delRv);
		panel_c2R.add(title_sales_0);
		panel_c2R.add(panel_t1);
		panel_t1.setLayout(new FlowLayout());
		panel_t1.add(title_sales);
		panel_t1.add(sales);
		sales.setEditable(false);
		sales.setText(idao.inMoney()-idao.outMoney()+"원");
		
		//버튼 리스너 등록
		btn_back.addActionListener(this);
		btn_delRv.addActionListener(this);
		btn_emp.addActionListener(this);
		btn_ret.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_back) {
			this.setVisible(false);
		}else if(e.getSource()==btn_emp) {
			if(inName.getText().equals("")) {
				JOptionPane.showMessageDialog(
						null,"직원정보를 입력하세요","에러",JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(
						null,"직원이 채용되었습니다","성공",JOptionPane.PLAIN_MESSAGE);
				addStaff();
			}
		}else if(e.getSource()==btn_ret) {
			if(tableS.getSelectedRowCount()==0) {
				JOptionPane.showMessageDialog(
						null,"선택된 직원이 없습니다","에러",JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(
						null,"퇴사처리 되었습니다","성공",JOptionPane.PLAIN_MESSAGE);
				delStaff();
			}
		}else if(e.getSource()==btn_delRv) {
			if(tableR.getSelectedRowCount()==0) {
				JOptionPane.showMessageDialog(
						null,"선택된 리뷰가 없습니다","에러",JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(
						null,"리뷰가 삭제되었습니다","성공",JOptionPane.PLAIN_MESSAGE);
				delReview();
			}
		}
	}
	private void allStaff() {
		ArrayList<Staff>slist=sdao.all();
		DefaultTableModel modelS=(DefaultTableModel)tableS.getModel();
		for(Staff temp:slist) {
			String []staff=new String[4];
			staff[0]=temp.getName();
			staff[1]=temp.getId();
			staff[2]=temp.getPwd();
			staff[3]=temp.getRank();
			modelS.addRow(staff);
		}
		
	}
	private void allReview() {
		ArrayList<ReviewDTO>rlist=rdao.showReview();
		DefaultTableModel modelR=(DefaultTableModel)tableR.getModel();
		for(ReviewDTO temp:rlist) {
			String []review=new String[4];
			review[0]=temp.getNo()+"번";
			review[1]="별점: "+temp.getStar();
			review[2]=temp.getContent();
			modelR.addRow(review);
		}
	}
	
	private void addStaff() {
		Staff s=new Staff();
		s.setName(inName.getText());
		s.setId(inId.getText());
		s.setPwd(inPwd.getText());
		s.setRank(inRank.getText());
		sdao.add(s);
		DefaultTableModel dm = (DefaultTableModel)tableS.getModel();
	    dm.getDataVector().removeAllElements();
	    allStaff();
	    inName.setText("");
	    inId.setText("");
	    inPwd.setText("");
	    inRank.setText("");
	}
	private void delStaff() {
		int idx=tableS.getSelectedRow()+1;
		
		
//		sdao.del(idx);
//		DefaultTableModel dm = (DefaultTableModel)tableS.getModel();
//	    dm.getDataVector().removeAllElements();
//	    allStaff();

	}
	private void delReview() {
//		int idx=tableR.getSelectedRow()+1;
//		rdao.delReview(idx);
//		DefaultTableModel dm = (DefaultTableModel)tableR.getModel();
//	    dm.getDataVector().removeAllElements();
//	    allReview();
//	    total_star.setText(rdao.avgStar()+"점");
	}
}
