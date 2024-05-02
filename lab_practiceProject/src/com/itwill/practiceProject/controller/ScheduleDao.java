package com.itwill.practiceProject.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.itwill.practiceProject.model.Schedule;
import com.itwill.practiceProject.model.TimeRange;

import oracle.jdbc.OracleDriver;

import static com.itwill.practiceProject.model.Schedule.*;
import static com.itwill.jdbc.OracleJdbc.*;

public class ScheduleDao {

	// singleton
	private static ScheduleDao instance = null;

	private ScheduleDao() {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ScheduleDao getinstance() {
		if (instance == null) {
			instance = new ScheduleDao();
		}

		return instance;
	}
	// singleton

	/**
	 * CRUD 메서드들에서 사용했던 리소스들을 해제.
	 * 
	 * @param conn Connection 객체
	 * @param stmt Statement 객체
	 * @param rs   ResultSet 객체
	 */
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * CRUD 메서드들에서 사용했던 리소스들을 해제.
	 * 
	 * @param conn Connection 객체
	 * @param stmt Statement 객체
	 */
	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}

	/**
	 * 날짜를 입력받아 DB에서 해당 날짜에 존재하는 일정들의 제목을 List로 반환
	 * 
	 * @param date 검색할 날짜
	 * @return 해당 날짜에 존재하는 일정들의 제목으로 만들어진 List<String>
	 */

	public List<String> readToDate(LocalDate date) {
		String sql = String.format("select %s from %s where %s = ?", COL_TITLE, TBL_SCHEDULE, COL_DATE);
		List<String> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(date));
			rs = stmt.executeQuery();

			while (rs.next()) {
				result.add(rs.getString(COL_TITLE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return result;
	}

	/**
	 * ResultSet에서 각 컬럼의 값들을 읽어서 Schedule 타입 객체를 생성하고 리턴
	 * 
	 * @param rs
	 * @return 생성된 Schedule 타입
	 * @throws SQLException
	 */
	private Schedule makeScheduleFromResultSet(ResultSet rs) throws SQLException {

		String title;
		Date date;
		String content;
		TimeRange during;
		String where;

		title = rs.getString(COL_TITLE);
		date = rs.getDate(COL_DATE);
		content = rs.getString(COL_CONTENT);
		if (rs.getTime(COL_START_TIME) != null && rs.getTime(COL_END_TIME) != null) {
			during = new TimeRange(rs.getTime(COL_START_TIME).toLocalTime(), rs.getTime(COL_END_TIME).toLocalTime());
		} else {
			during = null;
		}
		where = rs.getString(COL_LOCATION);

		Schedule result = new Schedule(title, date, content, during, where);

		return result;

	}

	/**
	 * 제목과 날짜를 이용하여 검색한 값을 Schedule 타입으로 변환 후 리턴
	 * 
	 * @param String title, LocalDate date
	 * @return 생성된 Schedule 객체
	 */
	public Schedule readToInfo(String title, LocalDate date) {
		final String sql = String.format("select * from %s where %s = ? and %s = ?", TBL_SCHEDULE, COL_TITLE, COL_DATE);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Schedule result = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setDate(2, Date.valueOf(date));
			rs = stmt.executeQuery();
			if (rs.next()) {
				result = makeScheduleFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return result;
	}

	/**
	 * 데이터베이스의 ScheduleDemo 테이블에 행을 삽입.
	 * 
	 * @param Schedule 테이블에 삽입할 제목, 날짜 정보를 가지고 있는 객체
	 * @return 테이블에 삽입된 행의 개수.
	 */
	public int update(Schedule sc, String oldTitle) {
		final String sql = String.format("update %s set %s = ?, %s = ?, %s = ? where %s = ? and %s = ?", TBL_SCHEDULE,
				COL_TITLE, COL_CONTENT, COL_LOCATION, COL_DATE, COL_TITLE);

		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;


		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sc.getTitle());
			stmt.setString(2, sc.getContent());
			stmt.setString(3, sc.getWhere());
			stmt.setDate(4, sc.getDate());
			stmt.setString(5, oldTitle);

			stmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}

		return result;
	}

	/**
	 * 해당하는 제목과 날짜를 가진 데이터 삭제
	 * 
	 * @param title
	 * @param date
	 */
	public int delete(String title, LocalDate date) {
		final String sql = String.format("delete from %s where %s = ? and %s = ?", TBL_SCHEDULE, COL_DATE, COL_TITLE);

		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(date));
			stmt.setString(2, title);
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		return result;

	}

	public int create(Schedule sc) {
		final String sql = String.format("insert into %s (%s, %s, %s, %s) values (?, ?, ?, ?)", 
				TBL_SCHEDULE,COL_DATE,COL_TITLE,COL_CONTENT,COL_LOCATION);
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, sc.getDate());
			stmt.setString(2, sc.getTitle());
			stmt.setString(3, sc.getContent());
			stmt.setString(4, sc.getWhere());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
	
		return result;
	}

}
