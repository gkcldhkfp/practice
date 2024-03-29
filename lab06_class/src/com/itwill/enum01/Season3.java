package com.itwill.enum01;

// enum �ڵ��� ���ط��� �ø��� Ŭ���� Ÿ���� ��� ������ �ݺ��� ���̰� ��ü ������ �����ִ� ���

public enum Season3 {
	SPRING("��"), SUMMER("����"), FALL("����"), WINTER("�ܿ�") ;
	
	private String name;
	
	private Season3() {}
	
	private Season3(String name) {
		this.name = name;
	}
	
	
	// enum�� �������� ���� ���ľ�� private�� ��� ����. private�� ���� ����. 
	public String getName() {
		return this.name;
	}
	
}	
