package basic;

public class VariableApp {
	public static void main(String[] args) {
		int su;
		su=100;
		System.out.print("초기값 = ");
		System.out.println(su);//변수에 저장된 값을 화면에 출력
		
		su=200;//변수에 기존값 대신 새로운 값 저장
		System.out.print("변경값 = ");
		System.out.println(su);
		
		System.out.println("==============================================================");
		int num=100;//변수 선언 및 초기값 저장
		
		System.out.println("num = "+num);
		System.out.println("==============================================================");
		System.out.println("올해는 "+2+0+2+3+"년입니다.");
		System.out.println(2+0+2+3+"년은 토끼띠해입니다.");//잘못된 결과 발생 - 실행 오류
		//"" : 비어있는 문자열 - NullString
		System.out.println(""+2+0+2+3+"년은 토끼띠해입니다.");
		System.out.println("==============================================================");
		
		int num1=100, num2=200;
		System.out.println("연산결과 = "+num1+num2);//잘못된 결과 발생 - 실행 오류
		System.out.println("연산결과 = "+(num1+num2));
		System.out.println("연산결과 = "+num1*num2);
		System.out.println("연산결과 = "+(num1*num2));
		System.out.println("==============================================================");
		int kor=88,eng=90;
		
		int tot=kor+eng;
		System.out.println("점수 합계 = "+tot);
		System.out.println("==============================================================");
		
	}
}








































