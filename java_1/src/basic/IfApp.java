package basic;

public class IfApp {
	
	public static void main(String[] args) {
		int su=10;
//		변수값이 50 이상인 경우에만 화면에 출력되게 하고싶으면?
		if (su>=50){
			System.out.println("su = "+su);
		}
		System.out.println("=============================================");
		int score=40;
//		점수가 60 이상인 경우 합격 메시지 출력, 미만인 경우 불합격 메시지 출력되게 하고 싶다~
		if (score>=60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다");
		}
		if (score<60) {
			System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다");
		}
		System.out.println("=============================================");	
	
		if (score>=60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다");
		} else {
			System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다");
		}
		System.out.println("=============================================");
		int num=8;
//		변수값을 홀수 또는 짝수로 구분하여 출력하는 프로그램을 만들 때
		if(num%2 !=0) {
			System.out.println(num+">>홀수");
		} else {
			System.out.println(num+">>짝수");
		}
		System.out.println("=============================================");
		String a="졸리다";
//		졸리면 집에간다
		if(a=="졸리다") {
			System.out.println("집에간다");
		} else {
			System.out.println("참는다");
		}
		System.out.println("=============================================");
		char mun='o';
//		문자변수에 저장된 문자값을 영문자와 비영문자로 구분하여 출려하는 프로그램을 만들 때
//		X>=작은값 && X<=큰값 : X는 작은값부터 큰값 사이의 범위안에 표현되는 값
		if (mun>='A' && mun<='Z' || mun>='a' && mun<='z') {
			System.out.println("[결과]"+mun+" = 영문자");
		} else {System.out.println("[결과]"+mun+" = 비영문자");
		}
		System.out.println("=============================================");
		
	}
}
