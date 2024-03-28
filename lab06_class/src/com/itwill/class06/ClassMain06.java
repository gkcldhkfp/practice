package com.itwill.class06;

public class ClassMain06 {

	public static void main(String[] args) {
		// Account 타입 객체 생성
		
		Account first = new Account(1, 1000);
		System.out.println(first);
		Account second = new Account(2, 50000);
		
		// first에 1000 입금
		
		first.deposit(1000);
		first.info();
		
		// first에서 2000 출금
		
		first.withdraw(2000);
		first.info();
		
		// second에서 first로 5000 송금
		second.transfer(first, 5000);
		
		first.info();
		
		second.info();
		
	}

}
