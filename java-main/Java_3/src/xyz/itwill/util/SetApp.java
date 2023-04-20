package xyz.itwill.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetApp {
	public static void main(String[] args) {
//		HashSet<String> set = new HashSet<String>();
		
		Set<String> set = new HashSet<String>();
		
		set.add("홍길동");
		set.add("박하윤");
		set.add("바악하윤");
		set.add("바악하아윤");
		set.add("바악하아유운");
		
		System.out.println("set.toString = "+set.toString());
		System.out.println("set = "+set);
		System.out.println("=============================================");
		set.add("홍길동");
		System.out.println("set = "+set);
		System.out.println("=============================================");
		System.out.println("요소의 갯수 = "+set.size());
		System.out.println("=============================================");
		set.remove("홍길동");
		System.out.println("set = "+set);
		System.out.println("=============================================");
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str+" ");
		}
		System.out.println();
		System.out.println("=============================================");
		
		for(String str : set) {
			System.out.println(str+" ");
		}
		System.out.println();
		System.out.println("=============================================");
	}
}
