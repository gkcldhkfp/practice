package com.itwill.class04;

public class Rectangle { // = ���簢��
	// field
	double width; // ���簢���� ���� ����
	double height; // ���簢���� ���� ����

	// ������
	// (1) �⺻ ������
	public Rectangle() { }
	
	// (2) ����/���θ� �ƱԸ�Ʈ�� ���� �޾Ƽ� �ʱ�ȭ �ϴ� ������
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// �޼���
	// (1) ���̸� ����
	public double area() {
		return (width * height);
	}

	// (2) �ѷ����̸� ����
	public double perimeter() {
		return (width + height) * 2;
	}

}
