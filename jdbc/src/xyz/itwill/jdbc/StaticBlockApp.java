package xyz.itwill.jdbc;

public class StaticBlockApp {
   public static void main(String[] args) throws ClassNotFoundException {
      //1.JVM은 ClassLoader 프로그램을 이용하여 클래스(Class 파일)를 읽어
      //메모리(Method영역)에 저장
      //2.new 연산자로 메모리에 저장된 클래스(Class 객체 - Clazz)의 생성자를
      //호출하여 객체(Object - Instance) 생성 - 객체는 메모리의 Heap 영역에 객체 생성
      //3.생성된 객체의 메모리 주소(HashCode)를 제공받아 참조변수를  생성하여 저장
      // - 참조변수는 메모리의 Stack 영역에 생성

	   Class.forName("xyz.itwill.jdbc.StaticBlock");

   }
}