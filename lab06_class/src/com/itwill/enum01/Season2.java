package com.itwill.enum01;

public class Season2 {
	
	public static final Season2 SPRING = new Season2("��");
	public static final Season2 SUMMER = new Season2("����");
	public static final Season2 FALL = new Season2("����");
	public static final Season2 WINTER = new Season2("�ܿ�");
	
	private String name;
	
//	private Season2() {}
	
	private Season2(String name) {
		this.name = name;
	}
	
	
	
	public String getName() {
		return this.name;
	}
	
}
