package example;

import java.util.Scanner;

public class GuGUDanAnswer {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
	
		int dan;
		while(true) {//키보드로 정수값을 입력받기 위한 반복문 - 무한루프 
			System.out.print("단 입력[2~9] >> ");
			dan=scanner.nextInt();
			if(dan>=2 && dan<=9) break;//정상적인 값이 입력된 경우 반복문 종료
			System.out.println("[에러]2~9 범위의 정수값만 입력 가능합니다.");
		}
		
		for(int i=1;i<=9;i++) {
			System.out.println(dan+" * "+i+" = "+(dan*i));
		}
		
		scanner.close();
	}
}
