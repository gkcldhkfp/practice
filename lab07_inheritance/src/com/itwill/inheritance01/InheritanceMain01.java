package com.itwill.inheritance01;

public class InheritanceMain01 {

	public static void main(String[] args) {
		// BasicTv 타입 객체 생성
		BasicTv tv1 = new BasicTv();
		tv1.powerOnOff(); // 기본으로 만들어 졌을 때에는 false로 만들어진 상태
		// if - false - else {}실행 p = t; -> TV ON
		
		tv1.ChannelUp();
		tv1.ChannelUp();
		tv1.ChannelUp();
		tv1.ChannelUp();
		tv1.channelDown();
		tv1.channelDown();
		tv1.channelDown();
		tv1.channelDown();
		
		tv1.volumelUp();
		tv1.volumelUp();
		tv1.volumelUp();
		tv1.volumelUp();
		
		tv1.volumeDown();
		tv1.volumeDown();
		tv1.volumeDown();
		tv1.volumeDown();
		
		tv1.powerOnOff(); // if - true - if{ p->f; } -> TV OFF
		//호출시 마다 값이 변경되어 실행됨.
		

		
		// SmartTv 타입 객체 생성
		SmartTv tv2 = new SmartTv();
		tv2.powerOnOff(); // 상위 클래스에서 상속받은 메서드를 호출.
		tv2.webBrowsing();
		
		
	}

}
