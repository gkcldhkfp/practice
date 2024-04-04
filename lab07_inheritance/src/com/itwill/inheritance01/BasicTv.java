package com.itwill.inheritance01;

public class BasicTv {
	// 상수 정의 :
	public static final int MIN_CHANNEL = 0;
	public static final int MAX_CHANNEL = 2;
	public static final int MIN_VOLUME = 0;
	public static final int MAX_VOLUME = 2;
	
	//필드
//	private boolean powerOn; //전원 상태(true -> ON, flase ->OFF)
//	private int channel; //현재 채널 번호
//	private int volume; // 음량
	
	protected boolean powerOn; //전원 상태(true -> ON, flase ->OFF)
	protected int channel; //현재 채널 번호
	protected int volume; // 음량 
	
	//생성자
	public BasicTv() {}
	
	public BasicTv(boolean powerOn , int channel, int volume) {
		this.powerOn = powerOn;
		this.channel = channel;
		this.volume = volume;
	}
	
	
	public boolean isPowerOn() { //boolean 타입은 is
		return powerOn;
	}

	public void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	//메서드
	/**
	 * TV가 켜져 있으면 끄고, TV가 꺼져 있는 켬
	 * powerOn의 값이 true이면 false변경, powerOn의 값이 false이면 true로 변경.
	 * @return powerOn의 값
	 */
	
	public boolean powerOnOff() { //switch-case문 : 정수, String , enum에서만 사용가능
									// boolean에서 사용 불가.
		if(powerOn) { // if(powerOn == true) boolean타입이면 굳이 조건으로 비교할 필요 없다
			powerOn = false;
			// 써서 안될 것은 아니지만 굳이 불 필요한 동작(비교)이다.
			System.out.println("TV OFF");
		} else {
			powerOn = true;
			System.out.println("TV ON");
		}
		
		return powerOn;
		
	}
	
	/**
	 * channelUp. 현재 채널의 값을 1증가.
	 * 만약 현재 채널 값이 채널의 최댓값(MAX_CHANNEL)인 경우, 채널의 최솟값(MIN_CHANNEL)으로 변경.
	 * @return 바뀐 현재 채널 값.
	 */
	public int ChannelUp() { // 일단 컴파일은 되게끔 껍데기는 만들고 
		// 그냥 일단 return 0;이라고 만들어 놓고
		// 코드 작성 후 변경해주기
		if(powerOn) {
		if(channel < MAX_CHANNEL) {
			channel++;
		} else {
			channel = MIN_CHANNEL;
		}
		System.out.println("CH: " + channel);
		}
		
		return channel;
	}
	
	/**
	 * channelDown. 현재 채널의 값을 1감소.
	 * 만약 현재 채널 값이 채널의 최솟값(MIN_CHANNEL)인 경우, 채널의 최댓값(MAX_CHANNEL)으로 변경.
	 * @return 바뀐 현재 채널 값.
	 */
	public int channelDown() {
		if(powerOn && channel > MIN_CHANNEL) {
			channel--;
		} else {
			channel = MAX_CHANNEL;
		}
		System.out.println("CH: " + channel);
		return channel;
	}
	
	/**
	 * volumelUp. 현재 음량의 값을 1증가.
	 * 만약 현재 채널 값이 볼륨의 최댓값(MAX_VOLUME)인 경우,음량을 변경하지 않음
	 * @return 바뀐 현재 음량 값.
	 */
	public int volumelUp() {
		if(powerOn) { // TV가 켜져 있을 때만
			if(volume < MAX_VOLUME) {
				volume++;
			}
			System.out.println("VOL: " + volume); // 볼륨 크기가 커지거나 그대로거나
			// 티비가 켜져 있다면 출력하겠다는 의미
		}
		return volume;
	}
	/**
	 * volumeDown. 현재 음량의 값을 1감소.
	 * 만약 현재 채널 값이 볼륨의 최솟값(MIN_VOLUME)인 경우,음량을 변경하지 않음
	 * @return 바뀐 현재 음량 값.
	*/
	public int volumeDown() {
		if(powerOn) {
			if(volume > MIN_VOLUME) {
				volume--;
			}
			System.out.println("VOL: " + volume);
		}
		return volume;
	}
}
