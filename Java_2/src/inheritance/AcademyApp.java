package inheritance;

public class AcademyApp {
	public static void main(String[] args) {
		//﻿학생정보를 저장하기 위한 요소들이 존재하는 배열을 선언 할 것
		/*
		AcademyStudent[] students = new AcademyStudent[3];
		AcademyInstructor[] instructors = new AcademyInstructor[1];
		AcademyStaff[] staffs = new AcademyStaff[1];
		*/
		
		AcademyPerson[] persons = new AcademyPerson[5];
		
		persons[0] = new AcademyStudent(1000,"홍길동","웹 개발자 과정");
		persons[1] = new AcademyStudent(2000,"일지매","웹 디자인 과정");
		persons[2] = new AcademyStudent(3000,"장길산","웹 보안 과정");
		persons[3] = new AcademyInstructor(4000,"임꺽정","Java 과목");
		persons[4] = new AcademyStaff(5000,"전우치","운영관리팀");
		
		for(AcademyPerson person : persons) {
			
			if(person instanceof AcademyStudent) {
			System.out.println(((AcademyStudent)person).getCourse()+"의 학생정보 >>");
			} else if(person instanceof AcademyInstructor) {
				System.out.println(((AcademyInstructor)person).getSubject()+"의 강사정보 >>");
			} else if(person instanceof AcademyStaff) {
				System.out.println(((AcademyStaff)person).getDepart()+"의 직원정보 >>");
			}
			
			person.display();
			System.out.println("=============================================");
		}
	}
}
