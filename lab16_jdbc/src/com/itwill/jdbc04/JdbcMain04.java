package com.itwill.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;


public class JdbcMain04 {

	public static void main(String[] args) {
		// 
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//드라이버 등록
			DriverManager.registerDriver(new OracleDriver());
			// DB 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// prepareStatement
			String sql = "delete from blogs where id = ?"; // 실행할 spl 문
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 1);
			
			int result = stmt.executeUpdate();
			System.out.println(result + "개 행이 delete 됨.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	

	}

}
