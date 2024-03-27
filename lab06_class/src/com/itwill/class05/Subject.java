package com.itwill.class05;

public class Subject {
	   // field
    int korean;
    int english;
    int math;
    int science;
    
    //  ������: (1)�⺻ ������. (2)�ƱԸ�Ʈ�� ���� ������.
    public Subject() { }
    
    public Subject(int korean, int english, int math, int science) {
    	this.korean = korean;
    	this.english = english;
    	this.math = math;
    	this.science = science;
    }
    //  �޼���: (1)���� ����. (2) ��� ����.
    
    public int total() {
    	// this. �� ��������.
    	return (korean + english + math + science);
    }

    
    public double mean() {
    	return (double)total() / 4; // this.total() ����
    }
    
    public void info() {
		System.out.println("����: " + korean);
		System.out.println("����: " + math);
		System.out.println("����: " + english);
		System.out.println("����: " + science);
		System.out.println("����: " + total());
		System.out.println("���: " + mean());

    }
}
