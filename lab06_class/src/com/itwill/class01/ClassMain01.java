package com.itwill.class01;


/*
 *  ��ü���� ���α׷��� ���(Object-Orienter Programming Language): Java, C++, C#, Kotlin, ...
 *  �������� ���α׷��� ���(Procedural Programming Language): C, ...
 *  
 *  ��ü(Object): ���. ���α׷����� ����Ϸ��� �ϴ� ���.
 *  Ŭ����(class): ��ü ���赵. ��ü�� ����� ���ؼ� �ʿ��� �ڵ�.
 *  - ��ü�� ������ �ϴ� "������"�� ����("�ʵ�")�� �����ϰ�,
 *  - ��ü�� ������ �ϴ� "���"�� �޼���� �����ϴ� �ڵ�
 *  - ������ ������ �� ����� �� �ִ� ������ Ÿ��.
 *  �ν��Ͻ�(Instance): ������ ������ ��ü.
 */

public class ClassMain01 {

	public static void main(String[] args) {
		String s1 = "�ȳ��ϼ���!";
		System.out.println("length1: "+ s1.length()); //lenhtg() : ���ڿ� ��ü�� ���(�޼���) 
		System.out.println("concat1: " + s1.concat("�� ���׿�..."));

		String s2 = new String("Hello");
		System.out.println("length2: "+ s2.length());
		System.out.println("concat2: " + s2.concat("Java"));
		
	}

}
