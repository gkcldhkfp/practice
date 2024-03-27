package com.itwill.modifier03;

/*
 * ������ ĸ��ȭ(encapsulation):
 * �ʵ���� private���� �����ؼ� Ŭ���� �ܺο����� ������ �ʵ���(���� ������ �� ������) ���߰�,
 * ��ſ� �ʿ��� ��쿡 ���ؼ� public���� ������ �޼��带 �����ؼ�
 * ���������� �ʵ���� ���� �аų� �����ϴ� ���� ����ϴ� ��ü���� ���α׷��� ���.
 * �������� ���Ȱ� ���Ἲ�� �����ϱ� ���ؼ� ĸ��ȭ�� ���.
 * getter �޼���: private �ʵ��� ���� �����ϴ� �޼���. args x return o
 * setter �޼���: private �ʵ��� ���� �����ϴ� �޼���. args o return x
 */

public class ModifierMain03 {

	public static void main(String[] args) {
		// Member Ÿ�� ��ü ����
		Member member = new Member("guest", "1234");
		System.out.println("ID: " + member.getMemberId());
		System.out.println("������ PW: " + member.getMemberPassword());
		member.setMemberPassword("531");
		System.out.println("������ PW: " + member.getMemberPassword());
		
		System.out.println("============================================");

		Person person = new Person("�ٳ���", 20);

		System.out.println("name = " + person.getname());
		System.out.println("������ age = " + person.getage());

		person.setage(25);

		System.out.println("������ age = " + person.getage());

	}

}
