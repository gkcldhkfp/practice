package com.itwill.class06;

public class ClassMain06 {

	public static void main(String[] args) {
		// Account Ÿ�� ��ü ����
		
		Account first = new Account(1, 1000);
		System.out.println(first);
		Account second = new Account(2, 50000);
		
		// first�� 1000 �Ա�
		
		first.deposit(1000);
		first.info();
		
		// first���� 2000 ���
		
		first.withdraw(2000);
		first.info();
		
		// second���� first�� 5000 �۱�
		second.transfer(first, 5000);
		
		first.info();
		
		second.info();
		
	}

}
