package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

	private boolean set;

	public TemperatureSensor() {
		this.set = false;
	}

	@Override
	public boolean isOn() {
		return this.set;
	}

	@Override
	public void setOn() {
		this.set = true;
	}

	@Override
	public void setOff() {
		this.set = false;
	}

	@Override
	public int read() {
		if (!set) {
			throw new IllegalStateException("The sensor is not on");
		} else {
			Random rs = new Random();
			return rs.nextInt(61) - 30;
		}
	}
}
