package com.itwill.ver02;

import java.util.Scanner;

import com.itwill.ver01.Contact;

// MVC 아키텍쳐에서 View 역할.
public class ContactMain02 {

	Scanner sc = new Scanner(System.in);
	ContactDaoImpl dao = new ContactDaoImpl();

	public static void main(String[] args) {
		ContactMain02 app = new ContactMain02();
		System.out.println("*** 연락처 프로그램 v0.2 ***");
		boolean run = true;
		while (run) {
			int menu = app.showMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveContact();
				break;
			case 2:
				app.readAll();
				break;
			case 3:
				app.readToIndex();
				break;
			case 4:
				app.updateToIndex();
				break;

			default:
				System.out.println("0~4 사이로 입력하시오");
			}

		}

		System.out.println(">>> 프로그램 종료 >>>");
	}

	private void updateToIndex() {
		while (true) {
			System.out.println("--- 연락처 수정 ---(메뉴로 : exit)");
			String s = sc.nextLine();
			if (s.equals("exit")) {
				return;
			}
			try {
				int index = Integer.parseInt(s);

				if (dao.validIndex(index)) {

					Contact contact = dao.read(index);

					if (contact == null) {
						System.out.println("해당 인덱스는 비어있습니다");
					} else {

						System.out.println("변경전 > " + contact);

						System.out.print("변경할 이름 = ");
						String name = sc.nextLine();

						System.out.print("변경할 번호 = ");
						String phone = sc.nextLine();

						System.out.print("변경할 메일 = ");
						String email = sc.nextLine();

						contact = new Contact(name, phone, email);

						dao.update(index, contact);

						System.out.println("변경완료");
						return;
					}

				} else {

					System.out.println("해당 인덱스에는 정보가 없음");
				}

			} catch (NumberFormatException e) {
				System.out.println("입력값은 정수여야 합니다");
			}
		}

	}

	private void readToIndex() {
		while (true) {
			System.out.println("--- 연락처 검색 ---(메뉴로 : exit)");
			System.out.print("인덱스 입력> ");

			String s = sc.nextLine();
			if (s.equals("exit")) {
				return;
			}
			try {

				int index = Integer.parseInt(s);

				if (dao.validIndex(index)) {

					Contact contact = dao.read(index);

					if (contact == null) {
						System.out.println("해당 인덱스는 비어있습니다");
					} else {
						System.out.println(contact);
						return;
					}

				} else {

					System.out.println("해당 인덱스에는 정보가 없음");
				}

			} catch (NumberFormatException e) {

				System.out.println("입력값은 정수여야 합니다");

			}
		}
	}

	private void readAll() {
		int index = 0;

		System.out.println("--- 연락처 목록 ---");

		Contact[] all = dao.read();

		for (Contact a : all) {

			if (a != null) {

				System.out.println("[" + index + "]" + a);

				index++;
			}
		}
	}

	private void saveContact() {
		if (dao.getCount() >= ContactDao.MAX_LENGTH) {
			System.out.println("저장 공간이 부족합니다.");
			return;
		}
		System.out.println("새로운 번호 저장");

		System.out.print("이름 입력> ");
		String name = sc.nextLine();

		System.out.print("번호 입력> ");
		String phone = sc.nextLine();

		System.out.print("메일 입력> ");
		String email = sc.nextLine();

		Contact contact = new Contact(name, phone, email);

		int result = dao.create(contact);

		if (result == 1) {
			System.out.println("저장 완료");
		} else {
			System.out.println("저장 실패");
		}
	}

	private int showMainMenu() {
		System.out.println("\n---------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("---------------------------------------");
		System.out.print("선택> ");

		try {
			int menu = Integer.parseInt(sc.nextLine());
			return menu;
		} catch (NumberFormatException e) {
			System.out.println("입력값은 정수여야 합니다");
			return showMainMenu();
		}

	}
}
