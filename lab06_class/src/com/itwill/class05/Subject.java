package com.itwill.class05;

public class Subject {
	   // field
    int korean;
    int english;
    int math;
    int science;
    
    // TODO ������: (1)�⺻ ������. (2)�ƱԸ�Ʈ�� ���� ������.
    public Subject() { }
    
    public Subject(int korean, int english, int math, int science) {
    	this.korean = korean;
    	this.english = english;
    	this.math = math;
    	this.science = science;
    }
    // TODO �޼���: (1)���� ����. (2) ��� ����.
    
    public int total() {
    	return (korean + english + math + science);
    }

    
    public double mean() {
    	return (total() / 4.0);
    }
}
