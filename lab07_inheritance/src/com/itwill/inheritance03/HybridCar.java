package com.itwill.inheritance03;

public class HybridCar extends Car { //Car를 상속 받아 확장.
	// 필드
	private int battery; // car에 없는 필드만 추가해서 사용하면 됨.
	
	// 생성자
	public HybridCar(int fuel, int speed, int battery) {
		//파라미터 선언 - int fuel, int speed는 Car생성 객체에 이용.
		
		// 상위 타입(car)에 기본 생성자가 없기 때문에 반드시 "명시적으로" {} 맨 첫 줄에
		// 아규먼트를 갖는 상위 클래스 생성자를 호출 해야 한다. -> super(fuel, speed);
		super(fuel, speed);
		this.battery = battery;
		
	}

	// 메서드
	public void charge(int battery) {
		this.battery = battery; // 아규먼트를 넣어서 호출하면 호출한 값으로 필드값 변경해 주는 메서드
		System.out.println("충전중: battery=" + battery);
	}
	
	@Override // 애너테이션 - 자바 컴파일러에게 알려주는 것. 자바 컴파일러가 사용
	// 자바 컴파일러가 진짜로 오버라이드를 하고 있는지 아닌지 검사를 해라 하고 코드에 써두는 것
	// 이게 없다고 해서 안되는 것은 아니다.
	// 만약 public void drive(int x)라고 선언하면 이건 오버라이드가 아님.
	// 파라미터가 다르면 모양이 똑같이 않음 덮어 쓸 수 없음(같은 메서드로 인식해서 재정의 못함) 
	// 파라미터가 달라서 - 다른 메서드로 인식함(오버로딩)
	public void drive() { // car에 있는 메서드와 동일한 메서드 public void drive(){..여기만 다름}
		System.out.println("하이브리드자동차 운전중(속력: " + getSpeed() + ", 연료: "
				+ getFuel()
				+ ", 배터리: " + battery
				+")"); //super.getSpeed()인데 super.이 생략 된 것
	}
}
