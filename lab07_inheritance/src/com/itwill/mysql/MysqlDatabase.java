package com.itwill.mysql;

import com.itwill.database.Database;

public class MysqlDatabase implements Database {
	public static final int VERSION = 1;
	
	public int select() {
		System.out.println(">>> MySQL 테이블 검색");
		return 1;
	}
	
	public int insert() {
		System.out.println(">>> MySQL 테이블 자료 추가");
		return 1;
	}
	
}
