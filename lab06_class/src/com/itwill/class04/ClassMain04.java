package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// �⺻ �����ڸ� ����ؼ� Rectangle ��ü ����, �޼��� ȣ��
		Rectangle rect1 = new Rectangle();

		System.out.println("rect1: " + rect1);
		System.out.println("rect1 ����: " + rect1.area());
		System.out.println("rect1 �ѷ�: " + rect1.perimeter());

		// �ƱԸ�Ʈ�� ���� �����ڸ� ���
		Rectangle rect2 = new Rectangle(3.0, 4.0);

		System.out.println("rect2 ����: " + rect2.area());
		System.out.println("rect2 �ѷ�: " + rect2.perimeter());

		rect2 = new Rectangle(4, 3);
		System.out.println("rect2: " + rect2);
	}

}