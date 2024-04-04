package com.itwill.inheritance02;

public class InheritanceMain02 {

    public static void main(String[] args) {
        // BusinessPerson 타입 객체 생성:
        BusinessPerson person1 = new BusinessPerson(); // 어떤 생성자가 호출 되는 지 궁금하면
        // ctrl누르고 생성자 호출 코드 클릭.
        System.out.println(person1.getName() + " : " + person1.getCompany());

        BusinessPerson person2 = new BusinessPerson("아이티윌");
        // 아규먼트 값으로 넘겨준 회사 이름 : 아이티윌
        // BusinessPerson 클래스의 아규먼트 1개짜리 생성자 호출
        
        System.out.println(person2.getName() + " : " + person2.getCompany());
        //person2.getName() : String com.itwill.inheritance02.Person.getName()
        //person2.getCompany() : String com.itwill.inheritance02.BusinessPerson.getCompany()
        
        
        BusinessPerson person3 = new BusinessPerson("오쌤", "아이티윌");
        System.out.println(person3.getName() + " : " + person3.getCompany());
    }

}



//package com.itwill.inheritance02;
//
//public class InheritanceMain02 {
//
//	public static void main(String[] args) {
//		//BusinessPerson 타입 객체 생성:
//		BusinessPerson person1 = new BusinessPerson();
//		System.out.println(person1.getName() + " : " + person1.getCompany());
//		
//
//		
//		BusinessPerson person3 = new BusinessPerson("오썜","아이티윌");
//		System.out.println(person3.getName() + ":" + person3.getCompany());
//	}
//
//}
