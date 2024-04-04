package com.itwill.inheritance05;

import java.util.Random;
import java.util.Scanner;

/*
 * java.lang.Object 클래스 : 자바의 최상위 클래스.
 * 자바에서 만들어진 모든 클래스는 기본적으로 Object 클래스를 확장(상속 extends)하게끔 되어있다.
 * 오브젝트 클래스에 있는 public으로 공개된 메서드들은 모든 하위 타입에서 사용 할 수 있다.
 * 오브젝트 클래스의 모든 메서드는 하위 클래스에서 재정의(override)를 할 수 있다.
 * 오브젝트 클래스가 가지고 있는 대표적인 메소드 - toString, equals(),hashCode(),...
 */

//public class T {} // 두 개의 public 클래스 X. public으로 선언된 클래스와 .java 파일 이름이 같아야 함.
//-> 그래서 public 클래스는 1개. public 아니고 그냥 클래스는 여러개 선언 가능.

class T {
	@Override
	public String toString() {
		
		return "T 타입 인스턴스";
	}
}

public class InheritanceMain05 {

	public static void main(String[] args) {
		T t =new T(); // 자바 컴파일러는 기본생성자 1개만 자동으로 만들어 줌.
		System.out.println(t); 
		System.out.println(t.toString());
		// void java.io.PrintStream.println(String x) - 오버 로딩
		
		System.out.println(t.getClass()); 
		//출력 결과-> class com.itwill.inheritance05.T 
		
		System.out.println(t.hashCode());
		
		T t1 = new T();
		T t2 = new T();
		T t3 = t1;
		System.out.println(t1.equals(t2)); // 출력 결과 -> false
		System.out.println(t1.equals(t3)); // 출력 결과 -> true
		// Object 클래스에서 상속 받은 equls()메서드 :
		// 두 객체가 같은 지(true), 다른 지(false)를 반환하는 메서드.
		// Object에서는 실제로 생성된 객체가 같으면 true를 리턴, 그렇지 않으면 false 리턴.
		
		// equals()메서드도 Object클래스에서 물려받음.
		// stack에 t1,t2,t3 지역변수 
		// heap에 T객체 생성 2개. @ABCD위치에 1개 , @ABFF위치에 1개
		// t1과 t3 같은 객체 참조하고 있음. 
		// t1과 t2 서로 다른 주소의 객체를 참조 하고 있음
		// 참조하는 객체의 주소를 보고 같으냐 다르냐 비교한 것.
		
		//System.out.println(Object x); 메서드는 객체의 문자열 표현식을 콘솔에 출력.
		// 아규먼트가 null이 아닌 경우에는 x.toString()이 리턴하는 문자열을 콘솔에 출력.
		// 아규먼트가 null이 아닌 경우에는 콘솔에 "null"이라고 출력.
		
		Object o = new Object();
		System.out.println(o);
		
		Random r = new Random();
		System.out.println(r); // Random클래스는 toString 메서드를 오버라이드 하지 않음.
		
		Scanner sc = new Scanner(System.in);
		System.out.println(sc); // 같은 Object 타입의 아규먼트인데, 
		//이건 출력 형태가 다름.
		//왜 그럴까? => Scanner 클래스가 toString()메서드(부모가 물려준 메서드를)를 
		// 오버라이딩(하위 클래스에서 메서드 재정의)함.
		
		
	}

}
