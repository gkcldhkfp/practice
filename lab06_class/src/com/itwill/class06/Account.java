package com.itwill.class06;

/**
 * ���� ���� ����. �Ӽ�: ���� ��ȣ, �ܰ�. ���: �Ա�, ���, ��ü, ���� ���.
 */
public class Account {
	// field
	int accountNo; // ���� ��ȣ
	int balance; // �ܰ�

	// constructor: �ƱԸ�Ʈ 2���� ���� ������
	public Account(int accountNo, int balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}
	// method �Ա�
	/**
	 * deposit(�Ա�). ���� �ܰ� �Աݾ��� ���ϰ�, �Ա� ���� �ܾ��� ����.
	 * 
	 * @param amount �Աݾ�(int)
	 * @return �Ա� �� �ܰ�(balance)
	 */
	public int deposit(int amount) {
		return balance += amount;
	}

	/**
	 * withdraw(���). ���� �ܰ��� ��ݾ��� ����, ��� ���� �ܰ� ����.
	 * 
	 * @param amount ��ݾ�(int)
	 * @return ��� �� �ܰ�(balance)
	 */
	public int withdraw(int amount) {
		return balance -= amount;
	}

	/**
	 * transfer(��ü). �� ������ �ܰ����� ��ü�ݾ� amount�� ����, ��ü�� ���� to�� �ܰ����� amount�� ����.
	 * 
	 * @param to     ��ü�� ����(Account).
	 * @param amount ��ü�� �ݾ�(int).
	 * @return true
	 */
	public boolean transfer(Account to, int amount) {
//		to.deposit(amount);
//		this.withdraw(amount);
		
		to.balance += amount;
		
		balance -= amount;
			
		return true;
	}

	/**
	 * ���� ���� ���
	 */
	public void info() {
		System.out.println("--- ���� ���� ---");
		System.out.println("���� ��ȣ: " + accountNo);
		System.out.println("�ܰ�: " + balance);
		System.out.println("---------------");

	}

}
