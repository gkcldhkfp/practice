package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {

		// Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
		Subject sub = new Subject();

		sub.english = 80;
		sub.korean = 90;
		sub.math = 60;
		sub.science = 85;

		System.out.println(sub.korean);

		Student stu = new Student(3, "홍길동", sub);

		System.out.println(stu.subject.math);

		System.out.println("total = " + sub.total());

		System.out.println("mean = " + sub.mean());

		stu.info();

	}

}
