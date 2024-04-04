package com.itwill.inheritance02;

public class Person {
    // 필드
    private String name;
    
    // 생성자
    public Person() { // name 필드를 null 로 초기화 해주는 생성자
        System.out.println("Person() 생성자");
    } //- 기본 생성자가 삭제시 BusinessPerson에서 에러.
    // 부모의 생성자를 명시적으로 호출 하지 않으면 부모의 기본생성자를 호출한다
    // 근데 기본 생성자가 없으니 에러.
    // 해결방법 - 부모 클래스의 기본 생성자를 만들어 주거나
    // 자식 클래스에서 명시적으로 아규먼트가 있는 부모 생성자를 호출하거나
    // super(""); 또는 super(null); 둘은 의미가 다르지만 
    // 부모 클래스에서 기본생성자를 만들 수 없다면
    // 자식 클래스에서 super(""); 또는 super(null);
    
    public Person(String name) {
        this.name = name;  // name 필드를 name(호출했을때 넣은 아규먼트값)으로 초기화 해주는 생성자
        System.out.println("Person(name) 생성자");
    }
    
    // 메서드
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}



//package com.itwill.inheritance02;
//
//public class Person {
//	// 필드
//	private String name;
//	
//	//생성자
//	public Person() {
//		System.out.println("Person 생성자"); //name 필드 null
//	}
//	
//	
//	
//	public Person(String name) {
//		this.name = name;
//		System.out.println("Person(name) 생성자"); // 
//	}
//	
//	
//
//	
//	
//	//메서드
//	public String getName() {
//	return this.name;
//	}
//	
//	public void setName() {
//		this.name = name;
//	}
//	
//}
