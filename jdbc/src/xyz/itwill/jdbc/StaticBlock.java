package xyz.itwill.jdbc;

public class StaticBlock {
   
	static {
		System.out.println("### StaticBlock 클래스의 정적영역에 작성된 명령 실행 ###");
		   StaticBlock sb = new StaticBlock();
		      
		   sb.display();
	}
	
	public StaticBlock() {
      System.out.println("### StaticBlock 클래스의 기본 생성자 호출 - 객체 생성 ###");
   }
   
   public void display( ) {
      System.out.println("### StaticBlock 클래스의 display() 메소드 호출 ###");
   }
}