package com.itwill.inheritance03;

public class InheritanceMain03 {

	public static void main(String[] args) {
		//Car(상위) 타입의 객체를 생성
		Car car1 = new Car(50, 30);
		car1.drive(); //-> 출력 결과: 자동차 운전중(속력: 30, 연료: 50)
		
		//car1. 인스턴스 참조 :  많이 보여주는 이유 설명 할 수 있어야..!
		// 우리가 만든 메서드들 이외 
		// 오브젝트 클래스로부터 메서드 상속 받음(자동) 
		// 모든 클래스의 부모에는 오브젝트 클래스가 있어서. 전부 상속 받음
		
		//HybridCar(하위) 타입의 객체를 생성:
		HybridCar car2 = new HybridCar(25, 30, 0);
		car2.drive(); //-> 상속의 장점 : 코드 재사용 가능. 부모로 부터 물려 받은 drive()메서드 호출
		car2.charge(100);
		//car2.drive(); 출력결과 : 하이브리드자동차 운전중(속력: 30, 연료: 25, 배터리: 0)
		//car2.drive(); 여기에 drive()메서드는 어디에 있는 메서드가 호출 된 걸 까요???
		
		// 다형성을 사용한 변수 선언과 초기화:
		// 많은 모양 형태가 여러가지다.
		// 문법 - 변수 선언할 때에는 SuperType var = new SubType();
		Car car3 = new HybridCar(50,40,100);
		car3.drive(); //-> 출력 결과 : 하이브리드자동차 운전중(속력: 40, 연료: 50, 배터리: 100)
		//다형성으로 선언되어 있더라도,하위 클래스에서 재정의한 메서드(오버라이드)가 호출되어 실행됨.
		((HybridCar)car3).charge(100);
		
		
		// SubType var = new SuperType(); -> 컴파일 오류
//		HybridCar car = new Car(100,100);
//		자동차는 하이브리드 자동차다 ⇒ X  
//		이건 객체를 하이브리드 자동차라고 부르고 있는 것 ⇒ 말이 안됨.
		
		
		Car[] cars = new Car[3];
		cars[0] = car1;
		cars[1] = car2;
		cars[2] = car3;
		
		// 다형성으로 
		// 변수 선언을 상위 타입의 배열로 선언을 하면
		// 상위 타입 객체도 하위 타입 객체도 다 넣을 수 있다.
		// 변수를 따로 따로 선언할 필요가 없다 -> 코드의 재 사용성이 높아진다
		
		for(Car c: cars) {
			test(c);
		}
		
		
	}//main 끝
	
	// Car c = new HC();
	public static void test(Car car) { //자동차와 하이브리드 자동차를 아규먼트로 넣어도 된다.
		// instanceof 연산자: 객체가 어떤 타입인 지를 반환하는 연산자
		//사용법 : 변수 instanceof 타입(클래스) - 변수가 클래스 타입이면 true, 그렇지 않으면 false를 리턴.
		if(car instanceof HybridCar) {
			System.out.println("하이브리드 자동차 검사...");
		} else if(car instanceof Car) {
			System.out.println("자동차 검사...");
		}
//		System.out.println("자동차 테스트...");
	}//-> static으로 선언한 이유: 객체 생성없이 메서드 호출을 위해서.
	
}
