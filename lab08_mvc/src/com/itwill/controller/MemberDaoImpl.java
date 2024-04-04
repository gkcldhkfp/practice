package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 컨트롤러 역할을 담당할 클래스. -> 싱글턴으로 구현.
public class MemberDaoImpl implements MemberDao {

	// ----------------- singleton 구현
	private static MemberDaoImpl instance = null;

	private MemberDaoImpl() {}

	public static MemberDaoImpl getInstance() {
		if (instance == null) {
			instance = new MemberDaoImpl();
		}

		return instance;
	}
	// ----------------- singleton 구현

	// 회원 정보를 저장할 배열 선언.
	private Member[] members = new Member[MAX_LENGTH];

	// 회원 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열 인덱스)
	private int count = 0; // 배열에 원소가 추가될 때마다 ++.

	public int getCount() {
		return count;
	}

	@Override
	public int create(Member member) {
		if (count < MAX_LENGTH) {
			members[count] = member;
			count++;

			return 1;
		}
		return 0;
	}

	@Override
	public Member[] read() {
		// 배열 members에 null이 아닌 원소들로만 이루어진 배열을 리턴
		Member[] returnMembers = new Member[count];
		for (int i = 0; i < count; i++) {
			returnMembers[i] = members[i];
		}

		return returnMembers;
	}

	@Override
	public Member read(int index) {
		return members[index];
	}

	@Override
	public int Update(int index, String password) {
		// index > MAX , index < 0
		members[index].setPassword(password);
		return 1;
	}

	public boolean IndexOutOfRange(int index) {

		if (index < 0 || index >= MAX_LENGTH) {

			System.out.println("인덱스 범위 초과. 0 ~ " + (MAX_LENGTH - 1) + "사이의 정수를 입력하시오");
			return false;

		} else if (read(index) == null) {
			System.out.println("해당 인덱스는 비어있습니다");

			return false;
		} else {
			return true;
		}
	}

}
