package com.itwill.modifier06;

public class Test {
	
	int x; // �ν��Ͻ� �ʵ� -> heap
	static int y; // ����(static) �ʵ� -> method ���� 
	//-> ���α׷� �ε� ������ method ������ ������ �����ǰ� �⺻������ �ʱ�ȭ��.
	
	
	// �ν��Ͻ� �޼���
	public void printFields() {
		System.out.println("--- �ν��Ͻ� �޼��� ---");
		System.out.println("x = " + x);
		System.out.println("y = " + y); // �ν��Ͻ� �޼���� static �ʵ带 ����� �� ����.
		System.out.println("--------------------");
	}
	
	// static �޼���
	public static void printFields2() {
		System.out.println("--- ����(static) �޼��� ---");
//		System.out.println("x = " + x); // static �޼���� static�� �ƴ� ����� ����� �� ����!
		System.out.println("y = " + y);
		System.out.println("------------------------");
	}

}
