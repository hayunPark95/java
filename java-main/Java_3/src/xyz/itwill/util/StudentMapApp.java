package xyz.itwill.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapApp {
	public static void main(String[] args) {
		List<Student> studentListOne = new ArrayList<Student>();
		studentListOne.add(new Student(1000,"ㅎㄱㄷ"));
		studentListOne.add(new Student(2000,"ㅇㄲㅈ"));
		studentListOne.add(new Student(3000,"ㅈㅇㅊ"));
		studentListOne.add(new Student(4000,"ㅇㅈㅁ"));
		studentListOne.add(new Student(5000,"ㅈㄱㅅ"));
		
		List<Student> studentListTwo = new ArrayList<>();
		studentListTwo.add(new Student(6000,"ㅇㅈㅅ"));
		studentListTwo.add(new Student(7000,"ㄱㅎㄷ"));
		studentListTwo.add(new Student(8000,"ㅅㄷㅇ"));
		studentListTwo.add(new Student(9000,"ㄱㅇㅁ"));
		
		Map<Integer, List<Student>> studentListMap = new HashMap<>();
		studentListMap.put(1, studentListOne);
		studentListMap.put(2, studentListTwo);
		
		for(Integer ban : studentListMap.keySet()) {
			System.out.println(ban+"반의 학생정보 >> ");
			
			List<Student> studentList = studentListMap.get(ban);
			for(Student student : studentList) {
				System.out.println(student);
			}
			System.out.println();
		}
		
	}
}
