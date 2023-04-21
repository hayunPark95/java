package xyz.itwill.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegularExpressionApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/*
		System.out.print("ID입력 >> ");
		String id = scanner.nextLine();
		
		if(id == null || id.equals("")) {
			System.out.println("[에러]ID를 입력하세요");
			System.exit(0);
		}
			
		String idReg = "^[a-zA-Z][a-zA-Z0-9]{5,19}$";
		
		if(!Pattern.matches(idReg, id)) {
			System.out.println("[에러]ID를 형식에 맞게 입력하세요");
			System.exit(0);
		}
		System.out.println("[메시지]형식에 맞는 ID를 입력했습니다");
		
		
		System.out.print("비밀번호 입력 >> ");
		String pw = scanner.nextLine();
		
		if(pw == null || pw.equals("")) {
			System.out.println("[에러]비밀번호를 반드시 입력하세요");
			System.exit(0);
		}
		
		String pwReg = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{8,30}$";
		
		if(!Pattern.matches(pwReg, pw)) {
			System.out.println("[에러]비밀번호를 형식에 맞게 입력하세요");
			System.exit(0);
		}
		System.out.println("[메시지]형식에 맞는 비밀번호를 입력했습니다");
		*/
		System.out.print("이메일 입력 >> ");
		String email = scanner.nextLine();
		
		if(email == null || email.equals("")) {
			System.out.println("[에러]이메일를 반드시 입력하세요");
			System.exit(0);
		}
		
		String emailReg = "^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)*$";
		
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[에러]이메일를 형식에 맞게 입력하세요");
			System.exit(0);
		}
		System.out.println("[메시지]형식에 맞는 이메일를 입력했습니다");
		
		scanner.close();
	}	
}
