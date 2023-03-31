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

	}
}
