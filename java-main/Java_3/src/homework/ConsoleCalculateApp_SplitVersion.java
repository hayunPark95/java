package homework;

import java.util.Scanner;

//키보드로 사칙 연산식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
//ex) 연산식 입력 >> 20 + 10
//    [결과]30
// => 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)만 허용
// => 형식에 맞지 않는 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 종료
// => 입력 연산식에 공백 입력이 가능하도록 처리
public class ConsoleCalculateApp_SplitVersion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String number;
		String numberTrim;
		

	
		int result =0;
		
		System.out.println("연산식 입력 >> ");
		number = scanner.nextLine();
		numberTrim = number.replace(" ","");
		if(numberTrim.indexOf("+") > -1) {
			String[] numArray = numberTrim.split("\\+");
			result = (Integer.parseInt(numArray[0])+Integer.parseInt(numArray[1]));
		} else if(numberTrim.indexOf("-") > -1) {
			String[] numArray = numberTrim.split("-");
			result = (Integer.parseInt(numArray[0])-Integer.parseInt(numArray[1]));
		} else if(numberTrim.indexOf("*") > -1) {
			String[] numArray = numberTrim.split("\\*");
			result = (Integer.parseInt(numArray[0])*Integer.parseInt(numArray[1]));
		} else if(numberTrim.indexOf("/") > -1) {
			String[] numArray = numberTrim.split("/");
			result = (Integer.parseInt(numArray[0])/Integer.parseInt(numArray[1]));
		} else {
			System.out.println("[에러] 잘못된 값 입력");
			return;
		}		
		System.out.println("[결과] "+result);
	}
}
