package com.itwill.practiceProject.model;

import java.time.LocalTime;

public class TimeRange {

	private LocalTime startTime;
	private LocalTime endTime;
	
	public TimeRange() {
		this.startTime = LocalTime.of(0, 0);
        this.endTime = LocalTime.of(23, 59);
	}

	public TimeRange(LocalTime startTime, LocalTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return startTime.toString() + "부터 " + endTime.toString() + "까지";
	}
}
