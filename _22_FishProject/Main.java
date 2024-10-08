package _22_FishProject;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("FishWorld");
		FishService fs=new FishService();
		fs.menu();
		
		//DAO 단위 테스트: DAO add() 기능 테스트, 결과: 성공
//		FishDAO f=new FishDAO();
//		FishDTO d=new FishDTO();
//		d.setId("aa");
//		d.setPwd("ppp");
//		f.add(d);
	}

}
