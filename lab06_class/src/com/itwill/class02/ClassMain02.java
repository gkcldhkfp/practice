package com.itwill.class02;

public class ClassMain02 {

	public static void main(String[] args) {
		// Score ��ü�� ����:
		Score score1 = new Score(); // -> ��� �ʵ�� �⺻������ ������.
		System.out.println("Java = " + score1.java);

		// score1 �ν��Ͻ��� �ʵ� �� ����:
		score1.java = 100;
		score1.sql = 90;
		score1.javascript = 85;

		// score1 �ν��Ͻ��� �޼��� ȣ��:
		System.out.println("���� = " + score1.getTotal());
		System.out.println("��� = " + score1.getMean());

		// �ƱԸ�Ʈ�� ���� �����ڸ� �̿��� score ��ü ����:
		Score score2 = new Score(90, 95, 80);

		System.out.println("score2 Java = " + score2.java);
		System.out.println("score2 ���� = " + score2.getTotal());
		System.out.println("score2 ��� = " + score2.getMean());

	}

}
