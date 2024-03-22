package com.itwill.switch02;

import java.util.Random;

public class SwitchMain02 {

	public static void main(String[] args) {
		// Random 타입의 변수를 선언하고, 초기화
		Random roll = new Random();
		
		// 정수 타입의 변수에 1 ~ 4까지의 정수 난수 1개를 저장.
		int code = roll.nextInt(1,5); // 1이상 5 미만의 난수
		
		System.out.println("code = "+code);
		
		switch(code) {
		case 1, 3:
			System.out.println("남성");
			break;
		case 2, 4:
			System.out.println("여성");
			
		}

	}

}
