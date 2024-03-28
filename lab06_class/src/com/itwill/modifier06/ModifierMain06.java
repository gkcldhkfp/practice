package com.itwill.modifier06;

/*
 * ���� ���ľ�(access modifier)�� ���� �������� ����� �� ����!
 * 
 * final ���ľ� 
 * - Ŭ����, Ŭ������ ���(�ʵ�, �޼���), ���� �������� ��� ����.
 * - final �ǹ�: �ٲ� �� ����.
 * - final �ʵ�/��������: �� �� �ʱ�ȭ�� �Ǹ� ���̻� ���� ������ �� ���� ����. ���(constant)
 * - final �ʵ�� �ݵ��
 *   (1) ����� ���ÿ� �ʱ�ȭ �ϰų�
 *   (2) �ƱԸ�Ʈ�� ���� �����ڸ� �����ؼ� ��������� �ʱ�ȭ �ؾ� ��.
 *   
 * �ν��Ͻ� ���(�ʵ�, �޼���) vs ����(static) ���
 * 1. �ν��Ͻ� ���
 *   (1) static ���ľ ���� ���.
 *   (2) ��ü�� ������ �Ŀ� ���� ������ �̿��ؼ� ����ϴ� ���
 *   (3) �ν��Ͻ� �ʵ�� JRE(Java Runtime Environment)�� ����ϴ� �޸� ���� �߿� ���� ����.
 * 2. ���� ���(�ʵ�, �޼���)
 *   (1) static ���ľ ���� ���.
 *   (2) ��ü�� �������� �ʾƵ� ����� �� �ִ� ���.
 *   (3) Ŭ���� �̸��� �̿��ؼ� ����ϴ� ���. (��) Math.PI, Math.Random(), System.in, System.out, ...
 *   (4) ���� �ʵ�� JRE�� ����ϴ� �޸� ���� �߿� �޼��� ������ ����
 *   (5) ���� ������� ���α׷��� main() �޼��尡 ȣ��Ǳ� ����, ���α׷� �ε� ������ �޸𸮿� ������.
 *   (6) static(����) �޼���� static �ʵ�� �޼��常 ��� ����.
 */

public class ModifierMain06 {
	
	private static final int version = 1;
	
	private final String message; // ������ �� �ʱ�ȭ���� ���� field �ʵ�
	
	// final �ʵ带 ��������� �ʱ�ȭ�ϴ� ������:
	public ModifierMain06(String message) {
		this.message = message;
	}

	public static void main(String[] args) {
//		version = 2; // final �ʵ�� ���� ������ �� ����.
		
		// ���� ���� & �ʱ�ȭ
		int n1 = 10;
		n1 = 100;
	
		final int n2 = 10; // -> ���. final ���� ����
//		n2 = 100; // ���� ����(���Ҵ�)�� �� ����.
		
		final int n3;
		n3 = 100;
//		n3 =10; //-> final ���� ������ ����� �ʱ�ȭ�� ���� �� �� ������ �ʱ�ȭ �Ŀ� ���� ������ �� ����
		
		ModifierMain06 app = new ModifierMain06("���� �ľ�");
//		app.message = ""; // -> final �ʵ�� ��ü ���� ���Ŀ� ���� ������ �� ����.
		
		// Test Ŭ������ ����(static) ��� ���:
		System.out.println("Test.y = " + Test.y);
		Test.y = 100; // static �ʵ�� ��ü ������ ������� ����� �� ����.
		System.out.println("Test.y = " + Test.y);
		Test.printFields2();
		
		// Test Ŭ������ �ν��Ͻ�(static�� �ƴ�) ��� ���: ���� ��ü�� �����ؾ� ��.
		Test test = new Test();
		System.out.println("test.x = " + test.x);
		test.x = 200;
		System.out.println("test.x = " + test.x);
		test.printFields();

	}

}
