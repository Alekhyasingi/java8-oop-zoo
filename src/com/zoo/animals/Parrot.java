package com.zoo.animals;

import java.util.LinkedList;

/**
 * Parrot is subclass of Bird . Object of this class has all attributes of Bird
 * and also canSpeak
 * 
 * @author alekhya
 *
 */
public class Parrot extends Birds {
	private boolean canSpeak;

	/**
	 * Parrot Constructor
	 * 
	 * @param name
	 * @param favoriteFood
	 * @param friends
	 * @param wingspan
	 * @param canSpeak
	 */
	public Parrot(String name, String favoriteFood, LinkedList<Animal> friends, float wingspan, boolean canSpeak) {
		super(name, favoriteFood, friends, wingspan);
		this.canSpeak = canSpeak;
	}

	public boolean isCanSpeak() {
		return canSpeak;
	}

	public void setCanSpeak(boolean canSpeak) {
		this.canSpeak = canSpeak;
	}

	@Override
	public String toString() {
		return super.toString() + (this.isCanSpeak() ? "\n Can Speak" : "\n Cannot Speak");
	}
}
