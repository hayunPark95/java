package oop;

import java.util.Arrays;

public class ArraySortApp {
	public static void main(String[] args) {
		int[] array= {30,50,10,40,20};
		
		System.out.println("정렬 전 >>"+Arrays.toString(array));
		
		Arrays.sort(array);
		System.out.println("정렬 후 >>"+Arrays.toString(array));
	}
}
