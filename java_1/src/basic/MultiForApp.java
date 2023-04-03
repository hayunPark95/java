package basic;

public class MultiForApp {
	public static void main(String[] args) {
		int cnt=0;
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=4;j++) {
				cnt++;
			}
		}
		System.out.println("이동방법의 갯수 = "+cnt);
		System.out.println("=============================================");
		//★
		for(int i=1;i<=4;i++) {//행(Row)을 처리하기 위한 반복문
			for(int j=1;j<=7;j++) {//열을(column) 처리하기 위한 반복문
				System.out.print("★");
		}
		System.out.println();
		}
		System.out.println("=============================================");
		//★★★★★★★★★
		//★★★★★★★★★
		//★★★★★★★★★
		//★★★★★★★★★
		//★★★★★★★★★
		//★★★★★★★★★
		//★★★★★★★★★
		//★★★★★★★★★
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=8;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=============================================");
		//2*1=2     3*1=3     ...     8*1=8     9*1=9
		//2*2=4     3*2=6     ...     8*2=16     9*2=18
		//...
		//2*8=16     3*8=24     ...     8*8=64     9*8=72
		//2*9=19     3*9=27     ...     8*9=72     9*9=81
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				System.out.print(j+"*"+i+"="+(i*j)+"=\t");
			}
			System.out.println();
		}
		System.out.println("=============================================");
		//★★★★★
		//★★★★★
		//★★★★★
		//★★★★★
		//★★★★★
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=============================================");
		//★
		//★★
		//★★★
		//★★★★
		//★★★★★
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=============================================");
		//★★★★★
		//★★★★
		//★★★
		//★★
		//★
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=(6-i);j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=============================================");
		//★★★★★
		//★★★★
		//★★★
		//★★
		//★
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=============================================");
		}
}