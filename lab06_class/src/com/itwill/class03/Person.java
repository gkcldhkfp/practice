package com.itwill.class03;

public class Person {
	// field
	String name;
	int age;

	// constructor
	public Person() {	}
	
	public Person(String name, int age){
		this.name = name;
		this.age = age; 
				
	}
	
	
	// method
	public void introduce() {
		System.out.println("�ȳ��ϼ���, ���� " + name + "�Դϴ�.");
		System.out.println("�� ���̴� " + age + "�Դϴ�.");
	}

}
