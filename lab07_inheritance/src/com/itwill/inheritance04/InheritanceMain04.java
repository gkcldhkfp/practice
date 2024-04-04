package com.itwill.inheritance04;
	
/*
 * final: 변경할 수 없는. 
 * final 지역변수 : 값을 초기화 한 이후에 그 값을 변경할 수 없는(값을 재할당 할 수 없는) 지역 변수.
 * final 필드(클래스에서 {}에서 선언한 변수) :  
 *	 - 반드시 한 번은 명시적으로 초기화 해야하고, 이 후에는 값을 변경할 수 없는 필드.
 * 1. final 필드를 선언과 동시에 초기화 하거나
 * 2. final 필드를 초기화 할 수 있는 아규먼트를 갖는 생성자를 작성.
 * 
 * final 메서드: 변경할 수 없는 메서드.
 * 
 * final 클래스: 변경할 수 없는 클래스.
 * 
 * 
 */	
// class MyString extends String {} -> final이 붙은 클래스는 상속 받을 수 없다.

class A{ // 상위 클래스 A
	public void test1() { // 서브 클래스에서 메서드 변경 허용
		System.out.println("test1");
		
	}
	
	public final void test2() { // final 서브 클래스에서 메서드 변경 불가.
		System.out.println("test2");
	}
}

class B extends A{ // 서브 클래스 B에서 
	@Override
	public void test1() { // 상위 클래스 A의 메서드 test1 오버라이드(메서드 재정의)
		System.out.println("B overrides test1");
	}
	
class C{}
final class D{}

//class F extends D{} 
	
	
//	public void test2() { //->  상위 클래스에서 final로 선언된 메서드는 하위 클래스 오버라이드 불가.
//		System.out.println("...");
//	}
	
}

public class InheritanceMain04 {

	public static void main(final String[] args) {
		

	}

}
