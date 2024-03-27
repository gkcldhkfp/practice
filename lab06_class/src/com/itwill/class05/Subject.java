package com.itwill.class05;

public class Subject {
	   // field
    int korean;
    int english;
    int math;
    int science;
    
    //  생성자: (1)기본 생성자. (2)아규먼트를 갖는 생성자.
    public Subject() { }
    
    public Subject(int korean, int english, int math, int science) {
    	this.korean = korean;
    	this.english = english;
    	this.math = math;
    	this.science = science;
    }
    //  메서드: (1)총점 리턴. (2) 평균 리턴.
    
    public int total() {
    	// this. 은 생략가능.
    	return (korean + english + math + science);
    }

    
    public double mean() {
    	return (double)total() / 4; // this.total() 가능
    }
    
    public void info() {
		System.out.println("국어: " + korean);
		System.out.println("수학: " + math);
		System.out.println("영어: " + english);
		System.out.println("과학: " + science);
		System.out.println("총점: " + total());
		System.out.println("평균: " + mean());

    }
}
