package com.itwill.modifier03;

public class Person {
	private String name; // �б� ���� �ʵ�
	private int age; // �б�/���� �ʵ�

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getname() {
		return this.name;
	}

	public int getage() {
		return this.age;
	}

	public void setage(int age) {
		if (age > 0) {
			this.age = age;
		}
	}
}
