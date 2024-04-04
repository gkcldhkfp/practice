package com.itwill.inheritance03;

// 하이브리드 자동차는 자동차이다. -> yes
// 상위 타입(부모) - 자동차
// 하위 타입(자식) - 하이브리드 자동차
// 자바 문법으로는 -> class HybridCar extends Car

public class Car {
	
	//필드 - 자동차가 갖는 속성
	private int fuel; //연료
	private int speed; //속력
	
	//생성자(객체 생성할 때 초기화하는 역할)
	public Car(int fuel, int speed) {
		this.fuel = fuel;
		this.speed = speed;
	}
	
	//getter & setter

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	// 메서드
	public void drive() {
		System.out.println("자동차 운전중(속력: " + speed + ", 연료: " + fuel + ")");
		
	}
	
	

}
