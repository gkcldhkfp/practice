package com.itwill.modifier03;

public class Person {
	private String name; // �б� ���� �ʵ�
	private int age; // �б�/���� �ʵ�

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}
	}
}
