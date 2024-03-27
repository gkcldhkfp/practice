package com.itwill.modifier01;

/*
 * Ŭ������ ���: �ʵ�(field), ������(constructor), �޼���(method)
 * Ŭ���� ������� ����(���ü�) ���ľ�(access modifier):
 * - Ŭ������ ������� ������ �� �ִ�(��������) ������ �����ϴ� ���ľ�
 * - ������ ����:pirvate < (package) < protected < public  
 * (1) private : ����� Ŭ���� �ȿ����� ������ �� �ִ�(���̴�) ���.
 * (2) (package) : ���ľ ������� ���� ���. ���� ��Ű���� �ִ� Ŭ�������� ������ �� �ִ�(���̴�) ���.
 * (3) protected : ���� ��Ű���� �ְų� �Ǵ� ����ϴ� Ŭ�������� ������ �� �ִ�(���̴�) ���. 
 * (4) public : ��𼭵� ������ �� �ִ�(���̴�) ���. ���� ������Ʈ ��ü
 */

public class ModifierMain01 {

	public static void main(String[] args) {
		// AccessExample Ÿ�� ��ü ����
		AccessExample ex = new AccessExample(1, 2, 3, 4);
		
//		System.out.println("a = " + ex.a);	//-> ������ ����: not visible(������ ����).
//		ex.a = 100;
		System.out.println("b = " + ex.b);
		ex.b = 200;
		System.out.println("b = " + ex.b);
		ex.info();
		
	}

}
