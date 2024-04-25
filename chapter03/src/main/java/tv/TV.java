package tv;

public class TV {
	private int channel;	// 1 ~ 255
	private int volume;		// 0 ~ 10
	private boolean power;
	
	public void status() {
		System.out.println(
				"TV[power=" + power +
				", channel=" + channel +
				", volume=" + volume +
				"]");
		//System.out.println("TV[power=off, channel,=10, volume=100]");
	}
	
	public TV(int i, int j, boolean up) {
		this.channel = 7;
		this.volume = 20;
		this.power = false;
	}

	public void power(boolean on) {
		this.power = on;
	}

	public void volume(boolean up) {
		if(up) {
			volume += 1;
			if(volume > 10) {
				volume = 0;
			}
		}
		else {
			volume -= 1;
			if(volume < 0) {
				volume = 10;
			}
		}
	}
	
	public void volume(int i) {
		if(0 <= i && i <= 10) {
			this.volume = i;			
		}
		else if(i < 0) {
			this.volume = 10;
		}
		else if(i > 10) {
			this.volume = 0;
		}
	}
	
	public void channel(boolean up) {
		if(up) {
			channel += 1;
			if(channel > 255) {
				channel = 1;
			}
		}
		else {
			channel -= 1;
			if(channel < 1) {
				channel = 255;
			}
		}
	}

	public void channel(int i) {
		if(1 <= i && i <= 255) {
			this.channel = i;			
		}
		else if(i < 1) {
			this.channel = 255;
		}
		else if(i > 255) {
			this.channel = 1;
		}
	}

	public int getVolume() {
		return volume;
	}

	public int getChannel() {
		return channel;
	}

}
