package com.itwill.modifier04;

import com.itwill.modifier05.PublicClassEx;

/*
 * Ŭ���� ����� ���� ������: private < (package) < protected < public
 * Ŭ������ ���� ������: 
 * (1)  public: ��𼭵�(��� ��Ű��)���� ������ Ŭ����. import ������ ����� �� ����
 * (2) (package): ���ľ ���� ���. ���� ��Ű�� �ȿ����� ������ Ŭ����.
 * (����) public Ŭ������ �̸��� java ������ �̸��� ���ƾ� ��
 * �ϳ��� java ���� �ȿ� �������� Ŭ������ �����ϴ� ���� ����.
 * �ϳ��� java ���� �ȿ��� 2�� �̻��� public Ŭ������ ������ �� ����.
 * �ϳ��� java ���Ͽ� �������� Ŭ������ ������ ���, ������ �Ŀ��� ������ Ŭ���� ����(����Ʈ �ڵ�)���� ������.
 *  ModifierMain04.java --[compile]-->A.class, B.class, ModifierMain04.class
 */

class A {}

class B {}

public class ModifierMain04 {

	public static void main(String[] args) {
		// PublicClassEx Ÿ�� ��ü ����
		PublicClassEx ex = new PublicClassEx();
		System.out.println(ex);
		
//		com.itwill.modifier05.PackageClassEx ex2; //-> ������ ����(not visible)

	}

}