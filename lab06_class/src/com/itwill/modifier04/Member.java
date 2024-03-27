package com.itwill.modifier04;

public class Member {
	// field
	private String memberId; // �б� ���� �ʵ�
	private String memberPassword; // �б�/���� �ʵ�

	// constructor
	public Member(String memberId, String memberPassword) {
		if (memberId != null && memberPassword != null) {
			this.memberId = memberId;
			this.memberPassword = memberPassword;
		} else {
			throw new IllegalArgumentException();
		}
	}

	// method
	// getter �޼���
	public String getMemberId() {
		return this.memberId;
	}

	public String getMemberPassword() {
		return this.memberPassword;
	}

	// setter �޼���
	public void setMemberPassword(String memberPassword) {
		if (memberPassword != null) {
			this.memberPassword = memberPassword;
		}
	}

}
