package com.itwill.ver01;

// ����ó �����͸� ǥ���ϴ� Ŭ����.
public class Contact {
	// �ʵ�
	private String name;
	private String phone;
	private String email;
	
	// ������(constructor)
	
	public Contact() {}
	
	public Contact(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	// �޼���
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// ����ó ����(�̸�, ��ȭ��ȣ, �̸���)�� ���ڿ��� ����
	
	public String toString() {
		return "Contact(name = "+ this.name 
				+", phone = " + this.phone
				+", email = " + this.email+")";
	}
	
}
