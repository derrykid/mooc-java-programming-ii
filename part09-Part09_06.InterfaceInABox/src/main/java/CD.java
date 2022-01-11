/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derry
 */
public class CD implements Packable {

	private String artist;
	private String name;
	private int publishYear;
	private double weight;

	public CD(String artist, String name, int year) {
		this.artist = artist;
		this.name = name;
		this.publishYear = year;
		this.weight = 0.1;
	}

	public double weight() {
		return this.weight;
	}

	@Override
	public String toString() {
		return this.artist + ": " + this.name + " (" + this.publishYear + ")";
	}
}
