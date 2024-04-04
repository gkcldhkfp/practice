package com.itwill.inheritance06;

// 2차원 평면의 점의 좌표를 표현
public class Point {
	//필드
	private int x;
	private int y;
	
	//constructor
	public Point() {}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	@Override //Object의 클래스에서 상속 받은 toString() 재정의
	public String toString() {
		return "Point(x=" + x + ",y=" + y + ")";
	}
	
	
	@Override
	public boolean equals(Object obj) { // 리턴 타입 -  boolean(true나 false를 리턴)
		// 아규먼트 Object 타입이면 전부 다 넘겨 줄 수 있음-> 다형성 사용.
		// 우선 넘겨 받은게 Point 타입인지 아닌지 검사해야 함.
		boolean result = false;
		
		if(obj instanceof Point) { //obj가 Point 타입이면
			//->obj가 Point타입인 경우에만
			Point pt = (Point) obj; //if문이 있어서 안전한 casting
			result = (this.x == pt.x) && (this.y == pt.y); 
			// == 비교 연산자 쓴 이유 : x,y가 int 정수라서
		}
		
		return result; 
	}
	
	@Override //Object 클래스의 hashCode() 메서드를 재정의 
	//-> 이건 맘대로 재정의 하면 안됨. 
	// 같은 정수값을 리턴하도록 만들면 됨.
	// A와 B가 같으면 -> A.x == B.y true -> A.(x+y) == B.(x+y) true
	public int hashCode() {
		return x + y; // 해시코드의 하나의 예. x-y 또는 x*y를 써도 됨.
		// 어떤 예를 들어도 되지만 A와 B는 같아야 함.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Point) {
//			Point point = (Point) obj;
//			if(x.equals(point.x)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if(x == y) {
//			return true;
//		} else {
//			return false;
//		}
//		 
//	}
	
}
