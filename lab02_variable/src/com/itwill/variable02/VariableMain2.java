package com.itwill.variable02;

public class VariableMain2 {

	public static void main(String[] args) {
		// 정수를 저장하는 변수 x를 선언하고, 갚을 저장(초기화)
		// 정수를 저장하는 변수 y를 선언하고, 값을 저장(초기화)
		// 두 변수 x와 y의 사칙연산(+, -, *, /) 결과를 각각 출력.
		
		int x = 6;
		
		int y = 3;

		System.out.println("x + y = "+ (x+y));
		System.out.println("x - y = "+ (x-y));
		System.out.println("x * y = "+ (x*y));
		System.out.println("x / y = "+ (x/y));
		System.out.printf("%d / %d = %d\n", x, y, (x/y));
		System.out.println("나눈 나머지 = " + (x % y));

		/* 나누기 연산자(/)
		 * (1) 정수 / 정수 결과는 나눈 "몫'
		 * (2) 실수 / 실수 , 실수, 정수, 정수/실수 결과는 소수점까지 계산.
		 * 
		 */
		double number1 = 5.0;
		double number2 = 3.0;
		System.out.println(number1 / number2);
		
	}

}
