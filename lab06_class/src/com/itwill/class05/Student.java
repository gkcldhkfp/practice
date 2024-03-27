package com.itwill.class05;

public class Student {

	// field
	int id; // �л� ��ȣ
	String name; // �л� �̸�
	Subject subject;// ���� ����

	// ������: (1)�⺻ ������. (2)�ƱԸ�Ʈ�� ���� ������.
	public Student() {
	}

	public Student(int id, String name, Subject subject) {
		this.id = id;

		this.name = name;

		this.subject = subject;
	}

	// �޼���: �л��� ����(��ȣ, �̸�, �� ������ ����, ����, ���)�� ���.
	public void info() {
		System.out.println("��ȣ = " + id);
		System.out.println("�̸� = " + name);
		if(subject != null) {
		subject.info();}
		else { 
			System.out.println("Subject = null");
		}
//		System.out.println("���� = " + subject.korean); // this.subject.korean ����
//		System.out.println("���� = " + subject.english);
//		System.out.println("���� = " + subject.math);
//		System.out.println("���� = " + subject.science);
//		System.out.println("���� = " + subject.total());
//		System.out.println("��� = " + subject.mean());

	}

}