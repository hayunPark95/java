package basic;

public class DataTypeApp {
	public static void main(String[] args) {
		
		System.out.println("<<정수형(IntegerType)>>");
		System.out.println("정수값(10진수 100) = "+100);
		System.out.println("정수값(8진수 100) = "+0100);
		System.out.println("정수값(16진수 100) = "+0x100);
		System.out.println("정수값(10진수100) = "+100L);
		
		System.out.println("정수값 = "+2147483647);
		
		System.out.println("정수값 = "+2147483648L);
		
		System.out.println("=================================================");
		int a1 = 127;
		int a2 = 32767;
		int a3 = 2000000000;
		long a4 = 4000000000L;
		
 
		System.out.println("a1 = "+a1);
		System.out.println("a2 = "+a2);
		System.out.println("a3 = "+a3);
		System.out.println("a4 = "+a4);
		
		
		long a5 = 100;//자료형이 큰 변수에 작은 리터럴 저장 가능 근데 권장사항은 아님
		System.out.println("a5 = "+a5);
		System.out.println("=================================================");
		
		System.out.println("<<실수형(DoubleType)>>");
		System.out.println("실수값(4Byte) = "+12.3F);
		System.out.println("실수값(8byte) = "+12.3);
		
		System.out.println("실수값(8byte) = "+0.000000000123);
		System.out.println("실수값(8Byte) = "+1.23E+10);
		
		
		float b1=1.23456789F; //가수부를 표현하기 위한 크기(정밀도) : 7자리 - 그니까 소숫점 밑에 7자리까지 올 수 있다 따라서 이 범위를 벗어난 9 같은경우는 반올림해서 앞자리로 들어간다
		double b2=1.23456789; //가수부를 표현하기 위한 크기(정밀도) : 15자리 - 그니까 소숫점 밑에 15자리까지 올 수 있다
		
		System.out.println("b1 = "+b1);
		System.out.println("b2 = "+b2);
	}
}













