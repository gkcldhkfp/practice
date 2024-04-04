package com.itwill.inheritance01;


// 같은 패키지 안이라서 import문장 사용 안함.

// 스마트TV는 기본TV를 확장한다. => 확장: 객체지향 개념에서는 상속한다는 의미.
// 상위 클래스(super),부모,기본 클래스 - 베이직 티비
// 반대 계념 하위(sub),자식,유도 클래스 - 스마트 티비

//상위 클래스가 java.lang.Object인 경우 extends Object는 생략 가능.
public class SmartTv extends BasicTv { // BasicTv기능 + 추가 기능
// 복붙의 문제점 : 스마트 티비 / 베이직 티비
// 기존 코드에 문제 또는 수정부분생기면 그것과 같은 기능을 하는 클래스에서도 또 수정을 해야한다.
	//=> 코드의 재 사용성이 떨어진다. 유지보수가 어렵다
	// 해결방법 : 상속
// 스마트 티비는 텔레비전의 일종.
// 기본티비기능 + 추가기능 => 스마트 티비
	//extends 확장하다 . 상속관계
//모든 클래스의 최상위 클래스는 java.lang.Object 클래스.
	
	private String ip;
	public void webBrowsing() {
		System.out.println("인터넷 연결");
		
	} 

	public void checkChannel() {
		// System.out.println(channel); // 못씀. 아무리 상속 받았다고 해도 못 쓴다.
		// 에러메세지 not visible : 물려받기는 했으나 보이지 않음.
		
		System.out.println(getChannel());
		// getter 메서드 -> 금고 열쇠.
	}
	
}
