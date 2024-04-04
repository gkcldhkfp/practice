package com.itwill.inheritance02;

// 회사원은 사람이다. (BusinessPerson IS A Person.)
public class BusinessPerson extends Person {
    // 필드
    private String company;
    
    /*
     * 상위 타입 객체가 먼저 생성 되어야 하위 타입의 객체를 생성할 수 있음.
     * 부모가 먼저 만들어져 있어야 자식을 만들어 낼 수 있다.
     * 생성자 호출 순서 : 상위 클래스 생성자 -> 하위 클래스 생성자 호출
     * 내부 적으로는 상위 먼저 초기화 되고 하위
     * 하위 클래스의 생성자에서 상위 클래스의 생성자를 명시적으로 호출 하지 않으면,
     * 상위 클래스의 "기본 생성자"가 자동으로 호출 된다.
     * super(); - 부모 클래스의 기본 생성자 호출 코드는 생략 가능하다.
     * 하위 클래스의 생성자에서 상위 클래스의 생성자를 명시적으로 호출할 떄는
     * super 키워드를 사용.()사용. 예) super(name);
     * 주의 점 - 에러 나는 경우.
     * 상위 클래스의 아규먼트를 갖는 생성자는 자동으로 호출 되지 않음.
     * 상위 클래스의 아규먼트를 갖는 생성자를 호출 하려면 super(아규먼트값);
     * 으로 명시적으로 호출 해야함.
     * 생성자 코드 안에서 {} super() 호출은 가장 맨 첫 줄에 작성 되어야 한다.
     * {}에서 super코드가 밑에 위치 하면 안됨.
     * 항상 부모를 먼저 만들고 자식 객체를 만들어야.
     * super의 위치,상위 클래스의 아규먼틀를 갖는 생성자를 호출하려면 명시적으로 호출해야하는것
     * 두 가지 주의 하기.
     * 
     *  가끔 상속해야 하는 부모 클래스의 기본 생성자가 없는 경우.
     *  코드 안에 직접 넣어 주어야 함.
     *  자동으로 만들어지는 super(); 상위 클래스의 기본생성자를 호출하는 코드에서 오류가 생김.
     *  
     *  
     */
    
    // 생성자
    public BusinessPerson() { // 모든 필드를 null로 만들어 주는 생성자
    	//BusinessPerson()을 만들 겠다고 하면 {}안에 별다른 코드가 없더라도
    	// 맨 첫줄에 사실 super(); 상위 클래스에 기본 생성자 호출 코드가 있는 것
    	// 부모객체가 먼저 만들어짐.
    	// 그럼 부모생성자 기본 호출 부분이 만들어진 것- 자동으로.
    	// 명시적으로 super(아규먼트값); 을 넣어도 되고 명시적으로 호출해 주지 않아도 자동으로 호출됨.
    	// heap에 -name생성 , - coumpany생성. 둘 다 기본 생성자라서 null로 초기화.
    	//- 회사원이라고 하는 객체
        System.out.println("BusinessPerson() 생성자");
    }
    
    public BusinessPerson(String company) { //name을 초기화 해주는 내용은 없음
//        super(); // main에서 호출시 -1. name  : null 초기화 (부모 클래스 기본 생성자 호출이라서)
        this.company = company; // 2. company : 아이티윌 초기화
        System.out.println("BusinessPerson(company) 생성자");
    }
    
    public BusinessPerson(String name, String company) { 
    	// String name - 오쌤, 1. heap name - 오쌤 객체 생성
        super(name); //-> 생략 불가능.	
        // 아규먼트를 갖는 생성자는 자동으로 호출해 주는게 아니다.
        // 이름이라는 아규먼트를 가져서 초기화 시키고 싶을 때 명시적으로 호출.
        // 상위 클래스의 아규먼트가 1개인 생성자를 명시적으로 호출하는 코드.
        // 생략 왜 불가능 하냐면 - 생략하면 부모클래스의 기본생성자 호출하는 코드가 나오니까.
        // super의 의미 : 상위 클래스(부모클래스)의 생성자를 호출한다
        // 두 가지 의미 : 부모 객체, super도 .사용 가능, ()를 쓰면 생성자 호출 코드
        this.company = company; // String company - 아이티윌 2. company - 아이티윌 객체 생성
        System.out.println("BusinessPerson(name, company) 생성자");
    }
    
    // 메서드
    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
}




//package com.itwill.inheritance02;
//
////회사원은 사람이다. (BusinessPerson IS A Person)
//public class BusinessPerson extends Person {
//	// 필드
//	private String company;
//	
//
//	//생성자
//	public BusinessPerson() {
//		System.out.println("BusinessPerson 생성자");
//	}
//	
//	public BusinessPerson(String name, String company) {
//		//super(); 생략 된 것. 생략가능한 코드.
//		super(name); //super 부모클래스의 인스턴스, 
//		// super(아규먼트1개짜리 생성자를); 부모클래스의 생성자를 명시적으로 부르는 것.
//		this.company = company;
//		System.out.println("BusinessPerson(name, company) 생성자");
//	}
//	//메서드
//	public String getCompany() {
//		return this.company;
//	}
//	
//	public void setCompany() {
//		this.company = company;
//	}
//	
//}
