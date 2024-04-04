package com.itwill.oracle;

import com.itwill.database.Database;

public class OracleDatabase implements Database{
	//field
	public static final int VERSION = 1;
	
	
	public int select() {
		System.out.println("Oracle 테이블 검색");
		return 0;
	}
	
	public int insert() {
		System.out.println("Oracle 테이블 데이터 추가");
		return 0;
	}
	
	//

}
