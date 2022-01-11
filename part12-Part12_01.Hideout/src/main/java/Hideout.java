/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derry
 */
public class Hideout<T> {

	private T element;

	public void putIntoHideout(T toHide) {
		this.element = toHide;
	}

	public T takeFromHideout() {
		T objectToReturn =  this.element;
		this.element = null;
		return objectToReturn;
	}
	public boolean isInHideout() {
		return this.element != null;
	}
}
