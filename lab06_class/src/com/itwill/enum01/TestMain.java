package com.itwill.enum01;

public class TestMain {

	public static void main(String[] args) {
		int season = Season1.SPRING;
		switch(season) {
		
		case Season1.SPRING :
			System.out.println("��");
			break;
		
		case Season1.SUMMER :
			System.out.println("����");
			break;
		
		case Season1.FALL :
			System.out.println("����");
			break;
		
		case Season1.WINTER :
			System.out.println("�ܿ�");
			break;
		
		default :
			System.out.println("�̻����");
		
		}
		
	
		Season2 season2 = Season2.SPRING;
		if(season2 == Season2.SPRING) {
			System.out.println(season2.getName());
		} else if(season2 == Season2.SUMMER){
			System.out.println("����");
		} else {
			System.out.println("...");
		}
		
		Season3 season3 = Season3.SPRING;
		System.out.println(season3);
		System.out.println(season3.getName());

	}

}
