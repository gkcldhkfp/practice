package com.itwill.file06;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable{
	private int id;
	private String name;
	private Score score;
	
	public Student(int id, String name, Score score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}
	
	public Student() {
	}
	
	@Override
	public String toString() {
		return "Student [id = " + id + ", name = " + name + ", score = " + score + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
	
	// 생성자, getter/setter, toString. 
	
}
