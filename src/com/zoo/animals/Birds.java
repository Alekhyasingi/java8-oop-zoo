package com.zoo.animals;

import java.util.LinkedList;

/**
 * Birds is subclass of Animal . Object of this class has all attributes of
 * Animal and also wingspan
 * 
 * @author alekhya
 *
 */
public class Birds extends Animal {
	private float wingspan;

	/**
	 * Birds Constructor
	 * 
	 * @param name
	 * @param favoriteFood
	 * @param friends
	 * @param wingspan
	 */

	public Birds(String name, String favoriteFood, LinkedList<Animal> friends, float wingspan) {
		super(name, favoriteFood, friends);
		this.wingspan = wingspan;
	}

	public float getWingspan() {
		return wingspan;
	}

	public void setWingspan(float wingspan) {
		this.wingspan = wingspan;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Wingspan:" + this.getWingspan();
	}
}
