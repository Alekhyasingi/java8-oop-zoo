package com.zoo.animals;

import java.util.LinkedList;

/**
 * Dog is subclass of Mammal . Object of this class has all attributes of Mammal
 * and also dogType
 * 
 * @author alekhya
 *
 */
public class Dog extends Mammal {
	private String dogType;

	/**
	 * Dog Constructor
	 * 
	 * @param name
	 * @param favoriteFood
	 * @param friends
	 * @param dogType
	 */
	public Dog(String name, String favoriteFood, LinkedList<Animal> friends, String dogType) {
		super(name, favoriteFood, friends);
		this.dogType = dogType;
	}

	public String getDogType() {
		return dogType;
	}

	public void setDogType(String dogType) {
		this.dogType = dogType;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Dog type:" + this.getDogType();
	}
}
