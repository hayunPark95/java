package oop;

public class Practice2 {
	public static void main(String[] args) {
		int[][] value=new int[3][];
		
		System.out.println("value = "+value);
		System.out.println("value[0] = "+value[0]);
		System.out.println("value[1] = "+value[1]);
		System.out.println("value[2] = "+value[2]);
		
		int[][] array={{10,20,30},{40,50},{60,70,80,90}};
		
		for(int[] arr:array) {
			for(int temp:arr) {
				System.out.print(temp+"\t");
			}
			System.out.println();
			
			
			
		}
	}
}
