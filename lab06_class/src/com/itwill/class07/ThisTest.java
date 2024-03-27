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
		//-> this : ThisTest Ÿ������ ������ ��ü(�ν��Ͻ�)
	}
	
	
	public ThisTest(int x) {
//		this.x = x;
		this(x, 0, 0); //-> ThisTest Ŭ������ �ٸ� ������ ȣ��
		// (����) this(...) �����ڸ� ȣ���ϴ� �ڵ�� �ٸ� ���๮�麸�� ���� ����Ǿ�� ��.
		
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
