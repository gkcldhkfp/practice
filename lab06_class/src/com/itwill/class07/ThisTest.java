package com.itwill.class07;

public class ThisTest {
	//field
	int x;
	int y;
	int z;
	
	// constructor
	public ThisTest() {}
	
	public ThisTest(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		//-> this : ThisTest 타입으로 생성된 객체(인스턴스)
	}
	
	
	public ThisTest(int x) {
//		this.x = x;
		this(x, 0, 0); //-> ThisTest 클래스의 다른 생성자 호출
		// (주의) this(...) 생성자를 호출하는 코드는 다른 실행문들보다 먼저 실행되어야 함.
		
	}
	
	public ThisTest(int x, int y) {
//		this(x, y, 0);
		this();
		this.x = x;
		this.y = y;
	}
	
	public void info() {
		System.out.printf("x = %d, y = %d, z = %d\n",this.x, this.y, this.z);
	}
	
}
