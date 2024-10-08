package openIdea;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("/////아이디어 공모전/////");
		Service s=new Service();
		s.menu();
		
		//테스트
//		IdeaDAO idao=new IdeaDAO();
//		IdeaDTO idto=new IdeaDTO();
//		idto.setTitle("자바");
//		idto.setContent("공부하기");
//		idto.setWriter("신태균");
//		idao.add(idto);
	}

}
