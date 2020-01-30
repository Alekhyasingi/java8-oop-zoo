package com.zoo.animals;

import java.util.LinkedList;

/**
 * Chicken is subclass of Bird . Object of this class has all attributes of Bird
 * and also isBroiler
 * 
 * @author alekhya
 *
 */
public class Chicken extends Birds {
	private boolean isBroiler;

	/**
	 * Chicken Constructor
	 * 
	 * @param name
	 * @param favoriteFood
	 * @param friends
	 * @param wingspan
	 * @param isBroiler
	 */
	public Chicken(String name, String favoriteFood, LinkedList<Animal> friends, float wingspan, boolean isBroiler) {
		super(name, favoriteFood, friends, wingspan);
		this.isBroiler = isBroiler;
	}

	public boolean isBroiler() {
		return isBroiler;
	}

	public void setBroiler(boolean isBroiler) {
		this.isBroiler = isBroiler;
	}

	@Override
	public String toString() {
		return super.toString() + (this.isBroiler() ? "\n Is broiler" : "\n Is not broiler");
	}
}
