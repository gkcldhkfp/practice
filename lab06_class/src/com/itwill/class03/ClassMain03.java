package com.itwill.class03;

public class ClassMain03 {

	public static void main(String[] args) {
		// person Ÿ���� ��ü�� �⺻ �����ڸ� ȣ���ؼ� ����
		Person p1 = new Person();
		System.out.println(p1.name);	//-> null
		System.out.println(p1.age);		//-> 0 
		
		p1.name = "����";
		p1.age = 16;
		p1.introduce();
		
		// �ƱԸ�Ʈ�� ���� �����ڸ� ȣ���ؼ� Person Ÿ�� ��ü�� ����
		Person p2 = new Person("ȫ�浿", 20);
		p2.introduce();
	}

}