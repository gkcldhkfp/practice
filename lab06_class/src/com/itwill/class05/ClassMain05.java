package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {

		// Subject, Student Ŭ���� ��ü ������ �޼��� ȣ�� ��� �׽�Ʈ.
		// �⺻ Ÿ�� �����ڸ� ����ؼ� Subject Ÿ���� ��ü�� ����
		Subject sub = new Subject();

		sub.english = 80;
		sub.korean = 90;
		sub.math = 60;
		sub.science = 85;
		
		System.out.println("����: " + sub.korean);
		System.out.println("����: " + sub.math);
		System.out.println("����: " + sub.english);
		System.out.println("����: " + sub.science);
		System.out.println("����: " + sub.total());
		System.out.println("���: " + sub.mean());

		// �ƱԸ�Ʈ�� ���� �����ڸ� ����ؼ� Subject Ÿ���� ��ü�� ����
		Subject sub1 = new Subject(100, 80, 70, 90);

		sub1.info();

		// �⺻ Ÿ�� �����ڸ� ����ؼ� Student Ÿ���� ��ü�� ����
		Student stu1 = new Student();
		
		stu1.info();
			
		stu1.id = 2;
		stu1.name = "������";
		stu1.subject = new Subject();
		stu1.subject.korean = 100;
		stu1.subject.english = 95;
		stu1.subject.math = 99;
		stu1.subject.science = 95;
		
		stu1.info();
		
		
		// �ƱԸ�Ʈ�� ���� �����ڸ� ����ؼ� Student Ÿ���� ��ü�� ����
		Student stu = new Student(3, "ȫ�浿", sub1);

		stu.info();

	}

}
