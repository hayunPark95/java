package basic;

//자료형(DataType) : 값을 표현하기 위한 키워드 또는 특정 대상을 표현하기 위한 식별자
// => 값이나 특정 대상을 저장하기 위한 변수를 선언하기 위해 사용
//1.원시형(PrimitiveType) : 값을 표현하기 위한 자료형 - 키워드
// => 숫자형(정수형, 실수형, 문자형) - 연산 가능 , 논리형
//2.참조형(ReferenceType) : 특정 대상을 표현하기 위한 자료형 - 식별자(클래스)
// => String 클래스 : 문자열을 표현하기 위한 자료형(클래스)

public class DataTypeApp {
	public static void main(String[] args) {
		//정수형(IntegerType) 리터럴 : 소숫점이 없는 숫자값
		// => Java에서 정수형 리터럴은 기본적으로 4Byte(Integer)로 표현 >> -2147483648~2147483647
		System.out.println("<<정수형(IntegerType)>>");
		System.out.println("정수값(10진수 100) = "+100);//숫자값 - 10진수 정수형 리터럴 출력
		//println() 메소드는 정수값을 무조건 10진수로 변환하여 출력함
		System.out.println("정수값(8진수 100) = "+0100);//숫자값 - 8진수 정수형 리터럴 출력 , 그래서 이 라인도 10진수로 변환되서 나옴
		System.out.println("정수값(16진수 100) = "+0x100);//숫자값 - 16진수 정수형 리터럴 출력 , 그래서 이 라인도 10진수로 변환되서 나옴
		//System.out.printf(null, args) 이거쓰면 10진수로 변환안되고 그냥 나옴
		System.out.println("정수값(10진수100) = "+100L);//숫자값L - 10진수 정수형 리터럴(8Byte - LongTypeLiteral)
		
		System.out.println("정수값 = "+2147483647);
		//4Byte(32bit)로 표현 가능한 정수값의 한계치가 딱 이거임
		//System.out.println("정수값= "+2147483648); 이거 이러면 에러남 이거는 4Byte(32bit)의 범위를 넘어가버림 
		System.out.println("정수값 = "+2147483648L);
		//4Byte(32bit)로 표현 불가능한 정수값은 정수값 뒤에 [L]값을 붙여서 LongType의 정수값으로 해결한다
		
		//정수값을 표현하기 위한 자료형
		 //byte(1Byte) - 네트워크 프로그램 만들 때 사용함
		//byte : -128~127
		//short(2Byte) - 자바가 C언어에서 파생됬기 때문에 있는거 - 거의 안씀
		//short : -32768~32767
		//int(4Byte) - 정수값을 표현할 때 쓰는 자료형
		//int : 그 한 20억대 ~~ -20억대
		//long(8Byte) - 정수값이 24라인에서처럼 한계치 넘어갈 때 정수값 뒤에 L 붙여서 씀
		//long : 암튼 범위 많음
		 
		//정수값을 표현하기 위해 가장 많이 쓰는 자료형은 >>> int 변수! 
		//bit를 많이 쓸수록 좋은거 아닌가? - ㄴ쓸데없이 bit를 많이 잡아먹으면 안좋음 그래서 나중가면 byte로 짤라서 보냄 왜 와이? 길면 괜히 에러만 더 나나?
		System.out.println("=================================================");
		int a1 = 127;
		int a2 = 32767;
		int a3 = 2000000000;
		long a4 = 4000000000L;
		
 
		System.out.println("a1 = "+a1);
		System.out.println("a2 = "+a2);
		System.out.println("a3 = "+a3);
		System.out.println("a4 = "+a4);
		
		//int a5=100L; int변수면 저 100 정도 숫자는 충분히 카바가 가능함 그래서 L붙이면 데이터손실이 발생할 수 있음 - > 에러 발생
		
		long a5 = 100;//자료형이 큰 변수에 작은 리터럴 저장 가능 근데 권장사항은 아님
		System.out.println("a5 = "+a5);
		System.out.println("=================================================");
		//실수형(DoubleType) 리터럴 : 소숫점이 있는 숫자값이겠지 
		// => Java에서 실수형 리터럴은 기본적으로 8Byte(Double)로 표현 >> 부동 소수점 형식으로 숫자값 표현
		System.out.println("<<실수형(DoubleType)>>");
		System.out.println("실수값(4Byte) = "+12.3F);//실수값F >> 4Byte 실수형 리터럴(FloatType)
		System.out.println("실수값(8byte) = "+12.3);//실수값 .. 8byte 실수형 리터럴(DoubleType)
		//println()메소드는 실수값이 아주 작거나 큰 경우 지수형태로 변환하여 출력한다
		System.out.println("실수값(8byte) = "+0.000000000123);//실수값 .. 8byte 실수형 리터럴(DoubleType)
		System.out.println("실수값(8Byte) = "+1.23E+10);
		
		// 실수값을 표현하기 위한 자료형은 float(4Byte)과 double(8Byte)이 있음
		float b1=1.23456789F; //가수부를 표현하기 위한 크기(정밀도) : 7자리 - 그니까 소숫점 밑에 7자리까지 올 수 있다 
		double b2=1.23456789; //가수부를 표현하기 위한 크기(정밀도) : 15자리 - 그니까 소숫점 밑에 15자리까지 올 수 있다
		
		System.out.println("b1 = "+b1);
		System.out.println("b2 = "+b2);
	}
}













