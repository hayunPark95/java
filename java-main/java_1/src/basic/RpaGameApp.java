package basic;

import java.util.Scanner;

//가위바위보겜 만들기

public class RpaGameApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int count=0;
		
		while(true) {
			int cpu=(int)(Math.random()*3)+1;
			int user;
			while(true) {
				System.out.print("[1]가위, [2]바위, [3]보 가위바위보>>");
				user=scanner.nextInt();
				if(user>=1 && user<=3) break;
				System.out.println("[에러]가위 바위 보 중 하나를 선택하여 입력하시오");
			}
			System.out.print("[입력]컴퓨터 >>");
			switch(cpu) {
			case 1: System.out.print("가위");break;
			case 2: System.out.print("바위");break;
			case 3: System.out.print("보");break;
			}
			System.out.print(", 사용자 >>");
			switch(user) {
			case 1: System.out.print("가위");break;
			case 2: System.out.print("바위");break;
			case 3: System.out.print("보");break;			
			}
			System.out.println();
			if(cpu == user) {
				System.out.println("[결과]컴퓨터와 사용자가 서로 비겼습니다.");
			} else if(cpu==1 && user==2 || cpu==2 && user==3 || cpu==3 &&user==1){
				System.out.println("[결과]사용자가 컴퓨터를 이겼습니다");
				count++;
			} else {
				System.out.println("[결과] 사용자가 컴퓨터에게 졌습니다");
				break; 
			}
			System.out.println();
		}	
		System.out.println("=============================================");
		if(count==0) {
			System.out.println("[메시지]한번도 못이겼네요~");
		} else {
			System.out.println("[메시지] 사용자가 컴퓨터에게 "+count+"번 이겼네요~");
		}
		scanner.close();
	}
}
