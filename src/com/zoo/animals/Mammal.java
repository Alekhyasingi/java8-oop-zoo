package com.zoo.animals;

import java.util.LinkedList;

/**
 * Mammal is subclass of Animal . Object of this class has all attributes of
 * Animal
 * 
 * @author alekhya
 *
 */
public class Mammal extends Animal {
	/**
	 * Mammal Constructor
	 * 
	 * @param name
	 * @param favoriteFood
	 * @param friends
	 */
	public Mammal(String name, String favoriteFood, LinkedList<Animal> friends) {
		super(name, favoriteFood, friends);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
