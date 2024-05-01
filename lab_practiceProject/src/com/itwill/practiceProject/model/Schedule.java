package com.itwill.practiceProject.model;

import java.sql.Date;

public class Schedule {
	public static final String COL_TITLE = "TITLE";
	public static final String COL_DATE = "DATE_COLUMN";
	public static final String COL_CONTENT = "CONTENT";
	public static final String COL_START_TIME = "START_TIME";
	public static final String COL_END_TIME = "END_TIME";	
	public static final String COL_LOCATION = "LOCATION";	
	
	public static final String TBL_SCHEDULE = "SCHEDULEDEMO";
	
	private String title;
	private Date date;
	private String content;
	private TimeRange during;	
	private String where;
	
	//반복 여부

	@Override
	public String toString() {
		return "Schedule [title=" + title + ", date=" + date + ", content=" + content + ", during=" + during
				+ ", where=" + where + "]";
	}

	public Schedule(String title, Date date, String content, TimeRange during, String where) {
		this.title = title;
		this.date = date;
		this.content = content;
		this.during = during;
		this.where = where;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TimeRange getDuring() {
		return during;
	}

	public void setDuring(TimeRange during) {
		this.during = during;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
	
}
