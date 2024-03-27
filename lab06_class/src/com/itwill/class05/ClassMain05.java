package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {

		// Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
		// 기본 타입 생성자를 사용해서 Subject 타입의 객체를 생성
		Subject sub = new Subject();

		sub.english = 80;
		sub.korean = 90;
		sub.math = 60;
		sub.science = 85;
		
		System.out.println("국어: " + sub.korean);
		System.out.println("수학: " + sub.math);
		System.out.println("영어: " + sub.english);
		System.out.println("과학: " + sub.science);
		System.out.println("총점: " + sub.total());
		System.out.println("평균: " + sub.mean());

		// 아규먼트를 갖는 생성자를 사용해서 Subject 타입의 객체를 생성
		Subject sub1 = new Subject(100, 80, 70, 90);

		sub1.info();

		// 기본 타입 생성자를 사용해서 Student 타입의 객체를 생성
		Student stu1 = new Student();
		
		stu1.info();
			
		stu1.id = 2;
		stu1.name = "오리온";
		stu1.subject = new Subject();
		stu1.subject.korean = 100;
		stu1.subject.english = 95;
		stu1.subject.math = 99;
		stu1.subject.science = 95;
		
		stu1.info();
		
		
		// 아규먼트를 갖는 생성자를 사용해서 Student 타입의 객체를 생성
		Student stu = new Student(3, "홍길동", sub1);

		stu.info();

	}

}
