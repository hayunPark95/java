package basic;

public class OperatorApp {
	public static void main(String[] args) {
		System.out.println("10+20*3 = "+(10+20*3));
		System.out.println("(10+20)*3 = "+((10+20)*3));
		
		int a1=10;
		System.out.println("a1 = "+a1);
		System.out.println("-a1 = "+(-a1));
		
		System.out.println("20>10 = "+(20>10));
		System.out.println("!20>10 = "+!(20>10));
		
		int a2=10, a3=10;
		System.out.println("a2 = "+a2+",a3 = "+a3);
		
		++a2;
		--a3;
		System.out.println("a2 = "+a2+",a3 = "+a3);
		
		int a4=10, a5=10;
		System.out.println("a4 = "+a4+",a5 = "+a5);
		
		int result1=++a4;
		int result2=a5++;
		System.out.println("a4 = "+a4+",a5 = "+a5);
		System.out.println("result1 = "+result1+",result2 = "+result2);
		
		int b1=20,b2=10;
		System.out.println(b1+" * "+b2+" = "+(b1*b2));
		System.out.println(b1+" / "+b2+" = "+(b1/b2));
		System.out.println(b1+" % "+b2+" = "+(b1%b2));
		System.out.println(b1+" + "+b2+" = "+(b1+b2));
		System.out.println(b1+" - "+b2+" = "+(b1-b2));
		System.out.println("=====================================================");
		
		System.out.println("20 > 10 ="+(20>10));
		System.out.println("20 < 10 ="+(20<10));
		System.out.println("20 == 10 ="+(20==10));
		System.out.println("20 != 10 ="+(20!=10));
		
	}
}
