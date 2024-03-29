package com.itwill.enum01;

// enum 코드의 독해력을 늘리고 클래스 타입의 상수 선언의 반복을 줄이고 객체 생성을 막아주는 기능

public enum Season3 {
	SPRING("봄"), SUMMER("여름"), FALL("가을"), WINTER("겨울") ;
	
	private String name;
	
	private Season3() {}
	
	private Season3(String name) {
		this.name = name;
	}
	
	
	// enum의 생성자의 접근 수식어는 private만 사용 가능. private은 생략 가능. 
	public String getName() {
		return this.name;
	}
	
}	
