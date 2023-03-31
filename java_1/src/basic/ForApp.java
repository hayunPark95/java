package basic;

public class ForApp {
	public static void main(String[] args) {
		//"Java Programming"을 화면에 출력하고자 한다
		System.out.println("Java Programming");
		System.out.println("=============================================");
		//"Java Programming"을 화면에 5번 출력하고자 한다
		for(int i=1;i<=5;++i) { 
			System.out.println("Java Programming");
		}System.out.println("=============================================");
		for(int i=2;i<=6;i+=2) { 
			System.out.println("Java Programming");
		}System.out.println("=============================================");
		for(int i=1;i<=10;i++) { 
			if(i%2==0) {
			System.out.println(i+"\t");
			}
		}
		System.out.println();
		System.out.println("=============================================");
	}
}
