package application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author derry
 */
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

	private ArrayList<Sensor> sensors;
	private ArrayList<Integer> listOfAvg;

	public AverageSensor() {
		this.sensors = new ArrayList<>();
		this.listOfAvg = new ArrayList<>();
	}

	public void addSensor(Sensor toAdd) {
		this.sensors.add(toAdd);
	}

	@Override
	public boolean isOn() {
		int count = 0;
		for (Sensor per : this.sensors) {
			if (per.isOn() == true) {
				count++;
			}
		}
		if (count == this.sensors.size()) {
			return true;
		}
		return false;
	}

	@Override
	public void setOn() {
		this.sensors.forEach((per) -> {
			per.setOn();
		});
	}

	@Override
	public void setOff() {
		for (Sensor per : this.sensors) {
			per.setOff();
		}
	}

	public List<Integer> readings() {
		return this.listOfAvg;
	}

	@Override
	public int read() {
		if (this.sensors.isEmpty() || !this.isOn() ) {
			throw new IllegalStateException("Error");
		}
		int sum = 0;
		for (Sensor per : this.sensors) {
			sum = sum + per.read();
		}
		int average = sum / this.sensors.size();
		this.listOfAvg.add(average);
		return average;

	}

}
