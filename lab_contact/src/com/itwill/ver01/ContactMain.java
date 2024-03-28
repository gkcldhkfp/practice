package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain {
	private static final int MAX_LENGTH = 3; // ����ó �迭�� �ִ� ����(���Ұ���)

	private Scanner scanner = new Scanner(System.in);
	private Contact[] contacts = new Contact[MAX_LENGTH]; // ����ó�� �����ϱ� ���� �迭
	private int count = 0; // ������� ����ó �迭�� ����� ����.
	// �迭�� ���ο� ����ó�� ����� ������ count++�� ����.

	public static void main(String[] args) {

		System.out.println("*** ����ó ���α׷� v0.1");

		boolean run = true; // ���α׷� ��� ����(run=true) �Ǵ� ����(run=false) ���θ� �����ϱ� ���� ����.

		ContactMain app = new ContactMain();

		while (run) {
			int menu = app.showMainMenu();

			switch (menu) {
			case 0:
				run = false;
				break;

			case 1:
				app.saveNewContact();
				break;

			case 2:
				app.readAllContacts();
				break;

			case 3:
				app.readContactByIndex();
				break;

			case 4:
				app.updataContactByIndex();
				break;

			default:
				System.out.println("�޴� ��ȣ�� Ȯ���ϼ���.");
			}
		}

		System.out.println("*** ���α׷� ���� ***");
	}

	private void updataContactByIndex() {
		System.out.println("\n----- ����ó ���� -----");

		this.readAllContacts();
		System.out.println();
		
		System.out.print("�ε��� �Է�>> ");
		int index = Integer.parseInt(scanner.nextLine());

		if (index < count) {

			System.out.println("������: " + contacts[index]);

			System.out.print("�̸� ����>> ");
			String name = scanner.nextLine();

			System.out.print("��ȭ��ȣ ����>> ");
			String phone = scanner.nextLine();

			System.out.print("�̸��� ����>> ");
			String email = scanner.nextLine();

			// �Է��� �������� �迭�� ������ ������Ʈ.
			contacts[index].setPhone(phone);
			contacts[index].setName(name);
			contacts[index].setEmail(email);
			
		} else if (MAX_LENGTH < index) {
			
			System.out.println("�������� �ʴ� index �Դϴ�");
			
		} else {
			
			System.out.println("�ش� �ε����� ����ֽ��ϴ�.");
			
		}
	}

	private void readContactByIndex() {
		System.out.println("\n--- �ε��� �˻� ---");
		System.out.print("�ε��� �Է�>>");
		int index = Integer.parseInt(scanner.nextLine());

		// �ش� �ε����� ����ó�� ���
		if (index < count) {
			System.out.println(contacts[index].toString());
		} else if (MAX_LENGTH < index) {
			System.out.println("�������� �ʴ� index �Դϴ�");
		} else {
			System.out.println("�ش� �ε����� ����ֽ��ϴ�.");
		}
	}

	private void readAllContacts() {
		System.out.println("\n--- ����ó ��� ---");

		for (int i = 0; i < count; i++) {
			System.out.println("["+ i +"] "+contacts[i].toString());
		}
	}

	private void saveNewContact() {
		if (count < MAX_LENGTH) {
			System.out.println("\n--- �� ����ó ���� ---");

			System.out.print("�̸� �Է�>> ");
			String name = scanner.nextLine();

			System.out.print("��ȭ��ȣ �Է�>> ");
			String phone = scanner.nextLine();

			System.out.print("�̸��� �Է�>> ");
			String email = scanner.nextLine();

			Contact contact = new Contact(name, phone, email);

			// Contact Ÿ�� ��ü�� ����ó �迭 �ε��� count�� ����
			contacts[count] = contact;
			// �迭�� ���� �Ŀ��� ����ó ���� ����(�ε���)�� ����
			count++;
		} else {
			System.out.println("���� ������ �����մϴ�");
		}
	}

	private int showMainMenu() {
		System.out.println("\n---------------------------------------");
		System.out.println("[0]���� [1]���� [2]��� [3]�ε����˻� [4]����");
		System.out.println("---------------------------------------");
		System.out.print("����> ");

		int menu = Integer.parseInt(scanner.nextLine());

		return menu;
	}

}