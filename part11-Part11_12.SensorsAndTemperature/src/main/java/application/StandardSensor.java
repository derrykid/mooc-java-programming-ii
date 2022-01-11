/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author derry
 */
public class StandardSensor implements Sensor {

	private int num;

	public StandardSensor (int number) {
		this.num = number;
	}
	public boolean isOn() {
		return true;
	}

	public void setOn() {
		return;
	}     

	public void setOff() {
		return;
	}

	public int read() {
		return this.num;
	}
	
}
