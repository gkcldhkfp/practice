package com.itwill.modifier02;


import com.itwill.modifier01.AccessExample;
// �ٸ� ��Ű������ ����� Ŭ���� �̸����� ������ �����Ϸ��� 
// (1) import ������ �ۼ��ϰ� ���� ���𿡼� Ŭ���� �̸��� ����ϰų�,
// (2) import ���� ���� ��Ű�� �̸��� ������ ��ü Ŭ���� �̸����� ������ ������.
// java.lang. ��Ű���� ���Ե� Ŭ�������� import ���� ���� Ŭ���� �̸������� ���� ������ �� ����.
// (��) java.lang.Stringm java.lang.System, java.lang.Math, ...  lang = language ���θ�


public class ModifierMain02 {

	public static void main(String[] args) {
		// com.itwill.modifier01.AccessExample Ÿ���� ��ü�� ����
		
		
		
		
//		com.itwill.modifier01.AccessExample ex2 =
//				new com.itwill.modifier01.AccessExample(1, 20, 3, 4);
		AccessExample ex = new AccessExample(1, 2, 3, 4);
//		System.out.println(ex.b); //-> ������ ����: not visible(������ ����)
		ex.info();
		
	}

}
