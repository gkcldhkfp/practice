package com.itwill.ver02;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {

	private Contact[] contacts = new Contact[MAX_LENGTH];

	private int count = 0;
	
	private ContactDaoImpl() {}
	
	private static ContactDaoImpl instance = null;
	
	public static ContactDaoImpl getInstance() {
		if(instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}

	@Override
	public int create(Contact contact) {

		contacts[count] = contact;
		count++;

		return 1;
	}

	public int getCount() {
		return count;
	}

	@Override
	public Contact[] read() {

		return contacts;
	}

	@Override
	public Contact read(int index) {

		return contacts[index];
	}

	@Override
	public int update(int index, Contact contact) {

		contacts[index] = contact;

		return 1;
	}

	/**
	 * 인덱스 유효성 검사
	 * 
	 * @param index
	 * @return 유효하지 않은 index면 true, 유효하면 false
	 */
	public boolean validIndex(int index) {
		if (index < 0 || index >= MAX_LENGTH) {
			return false;
		}
		return true;
	}

}
