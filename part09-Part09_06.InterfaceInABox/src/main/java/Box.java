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

public class Box implements Packable{

	private ArrayList<Packable> itemList;
	private double capacity;

	public Box(double capacity) {
		this.itemList = new ArrayList<>();
		this.capacity = capacity;
	}

	public void add(Packable item) {
		if (this.weight() + item.weight() <= this.capacity) {
			this.itemList.add(item);
		}
	}

	@Override
	public double weight() {
		double sum = 0;
		for (Packable per: itemList) {
			sum += per.weight();
		}
		return sum;
	}

	@Override
	public String toString() {
		return "Box: " + this.itemList.size() + " items, total weight " + this.weight() + " kg";
	}
	
}
