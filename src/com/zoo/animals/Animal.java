package com.zoo.animals;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Animal is the super class of all classes each object of animal is defined
 * from this class
 * 
 * @author alekhya
 *
 */

public class Animal {

	private String name;
	private String favoriteFood;
	private LinkedList<Animal> friends = new LinkedList<>();

	/**
	 * Animal Constructor
	 * 
	 * @param name
	 * @param favoriteFood
	 * @param friends
	 */
	public Animal(String name, String favoriteFood, LinkedList<Animal> friends) {
		super();
		this.name = name;
		this.favoriteFood = favoriteFood;
		this.friends = friends;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public LinkedList<Animal> getFriends() {
		return friends;
	}

	public void setFriends(LinkedList<Animal> friends) {
		this.friends = friends;
	}

	/**
	 * get friends list if present from each animal
	 * 
	 * @return friends list
	 */
	public String getFriendsList() {
		return ((this.getFriends() != null && this.getFriends().size() == 0) ? "Nil"
				: (this.getFriends().stream().map(e -> e.getName())).collect(Collectors.joining(",")));
	}

	@Override
	public String toString() {

		return "Name:" + this.getName() + "\n Favorite food:" + this.getFavoriteFood() + "\n Friends:"
				+ getFriendsList();
	}

}
